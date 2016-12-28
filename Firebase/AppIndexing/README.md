Nguồn: https://codelabs.developers.google.com/codelabs/app-indexing


- What you'll learn
 * Write personal app content to the on-device index
 * Log user actions for public and personal content
 
 
### 7. Support Links For Your App Content

Đầu tiên, app của bạn sẽ thêm phần hỗ trợ các URL tương ứng với nội dung public trên website của app.
Website recipe-app.com và app Android đều thiết lập hỗ trợ các link có thể sử dụng và mở được trên cả hai nền tảng.
Bạn muốn ứng dụng sẽ mở một màn hình tương ứng với các link hướng tới ```recipe-app.com.```
Để làm được điều này, app sẽ hộ trợ URL match với các đường link dạng ```http://recipe-app.com/recipe/*``` để mở app.
Bằng cách thêm một <intent-filter> vào ```AnndroidManifest.xml```, ví dụ:

```xml
...
<activity
   android:name=".client.RecipeActivity"
   android:label="@string/app_name"
   android:exported="true"
   android:launchMode="singleTop"
   android:theme="@android:style/Theme.Holo.NoActionBar">
   <intent-filter android:label="@string/app_name" android:autoVerify="true">
       <action android:name="android.intent.action.VIEW" />
       <category android:name="android.intent.category.DEFAULT" />
       <category android:name="android.intent.category.BROWSABLE" />
       <!-- Accepts URIs that begin with "http://recipe-app.com/recipe" -->
       <data android:scheme="http"
           android:host="recipe-app.com"
           android:pathPrefix="/recipe" />
   </intent-filter>
</activity>
...
```
Kiểm tra xem ứng dụng của bạn có thể handle HTTP link trên hay không, cài đặt app và type command sau: 

>$ adb shell am start -a android.intent.action.VIEW \ -d "http://recipe-app.com/recipe/pierogi-poutine" com.packagename.recipe_app


Bạn đã làm cho ứng dụng có khả năng cung cấp các màn hình đúng với URL tương ứng tới recipe-app.com.
Đọc thêm về supporting HTTP link in app, <a href="https://firebase.google.com/docs/app-indexing/android/app#receive-incoming-links-in-your-app">Support links to your app content</a>

### 8. Write Personal Content to On-device Index
Lúc này, bạn có thể sử dụng API để lưu personal content to the on-device index. 
Ứng dụng Recipe có một tính năng cho phép người dùng bình luận và để lại một ghi chú
trên mỗi recipe để sử dụng trong tương lai. Bằng cách index user notes, 
API giúp hiển thị nội dung note recipe được index khi người dùng search nội dung đó trên Google App.


Đầu tiên, viết một ```IntentService``` cập nhật index  một cách định kỳ.
Code follow ```AppIndexingService.java```

```java

public class AppIndexingService extends IntentService {
...
   @Override
   protected void onHandleIntent(Intent intent) {
       ArrayList<Indexable> indexableNotes = new ArrayList<>();

       for (Recipe recipe : getAllRecipes()) {
           Note note = recipe.getNote();
           if (note != null) {
               Indexable noteToIndex = Indexables.noteDigitalDocumentBuilder()
                       .setName(recipe.getTitle() + " Note")
                       .setText(note.getText())
                       .setUrl(recipe.getNoteUrl())
                       .build();

               indexableNotes.add(noteToIndex);
           }
       }

       if (indexableNotes.size() > 0) {
           Indexable[] notesArr = new Indexable[indexableNotes.size()];
           notesArr = indexableNotes.toArray(notesArr);

           // batch insert indexable notes into index
           FirebaseAppIndex.getInstance().update(notesArr);
       }
   }
...
}
```

Cho phép Google Play Services gọi ```IntentService``` 
này bằng cách thêm nó vào ```AndroidManifest.xml```

```xml
<service android:name=".client.AppIndexingService"
  android:exported="true"
  android:permission="com.google.android.gms.permission.APPINDEXING">
   <intent-filter>
       <action android:name="com.google.firebase.appindexing.UPDATE_INDEX" />
   </intent-filter>
</service>
```



### 9. Update the On-device Index   

Khi mà user thêm 1 note, ứng dụng nên add thông tin đó tới the on-device index,
khi đó nó sẽ xuất hiện trong Google app. The API cung cấp nhiều cách để bạn có thể ghi personal content vào index.
Ví dụ sử dụng ```noteDigitalDocumentBuilder``` trong ```RecipeActivity.java```

```java
private void indexNote() {
   Note note = mRecipe.getNote();
   Indexable noteToIndex = Indexables.noteDigitalDocumentBuilder()
           .setName(mRecipe.getTitle() + " Note")
           .setText(note.getText())
           .setUrl(mRecipe.getNoteUrl())
           .build();

   Task<Void> task = FirebaseAppIndex.getInstance().update(noteToIndex);
   task.addOnSuccessListener(new OnSuccessListener<Void>() {
       @Override
       public void onSuccess(Void aVoid) {
           Log.d(TAG, "App Indexing API: Successfully added note to index");
       }
   });

   task.addOnFailureListener(new OnFailureListener() {
       @Override
       public void onFailure(@NonNull Exception exception) {
           Log.e(TAG, "App Indexing API: Failed to add note to index. " + exception
                   .getMessage());
       }
   });
}

```

Bây giờ, khi người dùng thêm 1 note vào Recipe App, nó cũng được thêm vào index.

>Best Practices for Personal Content
 * Wherever possible, use existing builders, such as those for messages, digital documents, and spreadsheets. For content types without a predefined builder, use Indexable.Builder().
 * Use predefined data types and properties from <a href="http://schema.org/">Schema.org</a>
 whenever possible, such as <a href="https://schema.org/DigitalDocument">DigitalDocument</a> ,  <a href="https://schema.org/Conversation">Conversation</a> or <a href="https://schema.org/Person">Person</a>.
 * Use predefined data types and properties from Schema.org whenever possible, such as DigitalDocument, Conversation or Person.
 * Use an accurate and descriptive title in your .update() call. The text defined in the title is used in the Google app.
 
 
 
### 10. Remove Items From the On-device Index
 
 Bất cứ khi nào người dùng xoá 1 note từ recipe, ứng dụng cũng nên xoá note từ the on-device index, 
 như thế nó sẽ không hiển thị trong kết quả search nữa.
 Bạn phải xoá các item từ index bằng associated URL.
 
 Sử dụng ```FirebaseAppIndex.getInstance()..remove()```, như trong ```RecipeActivity.java``` của demo.
 ```java
 ...
// Deletes or removes the corresponding notes from index.
String noteUrl = mRecipe.getNoteUrl();
FirebaseAppIndex.getInstance().remove(noteUrl);
 ```
 


### 11. Log User Actions on Public Content
Khi người dùng search trong Google app, nếu nội dung tìm kiếm mà liên quan tới nội dung trong app và bạn muốn app của bạn
sẽ có trong gợi ý autocomplete. Để làm được điều này, log user actions on the public content after adding it to the index..

```FirebaseUserActions.getInstance().start()``` function để đăng ký, sử dụng trong ```onStart()```.
Như trong ```RecipeActivity.java``` demo 

```java
@Override
public void onStart() {
   super.onStart();
   if (recipe != null) {
      indexRecipe();
      FirebaseUserActions.getInstance().start(getRecipeViewAction());
   }
}

private void indexRecipe() {
    Indexable recipeToIndex = new Indexable.Builder()
           .setName(mRecipe.getTitle())
           .setUrl(mRecipe.getRecipeUrl())
           .setImage(mRecipe.getPhoto())
           .setDescription(mRecipe.getDescription())
           .build();

    FirebaseAppIndex.getInstance().update(recipeToIndex);
}

private Action getRecipeViewAction() {
   return Actions.newView(mRecipe.getTitle(),mRecipe.getRecipeUrl());
}
```
 
 >Best Practices for Public Content
 - To accurately describe the user's actions, only call the FirebaseUserActions.getInstance().start() method once each time the user performs an action you want to log.
 - Inform your users that links visited in the app may be shared with Google to improve search experiences for all users.
 
 Khi người dùng kết thúc việc xem 1 recipe, gọi ```FirebaseUserActions.getInstance().end()``` để complete user action.
 
```java
@Override
public void onStop() {
   if (recipe != null) {
       FirebaseUserActions.getInstance().end(getRecipeViewAction());
   }
   super.onStop();
}
```



### 12. Log User Actions on Personal Content

Đối với public content, những dữ liệu hành động của người dùng đã được upload lên Google và Action.Builder 
mặc định cho phép điều này.

Đối với personal content, bạn nên truyền ```false``` vào ```setUpload()``` của Action.Builder để giữ lại dữ liệu
hành động của người dùng trên device, không upload lên Google như nội dung public.


Ví dụ trong RecipeActivity.java
```java
private Action getNoteCommentAction() {
   return new Action.Builder(Action.Builder.COMMENT_ACTION)
           .setObject(mRecipe.getTitle() + " Note", mRecipe.getNoteUrl())
           .setMetadata(new Action.Metadata.Builder().setUpload(false))
           .build();
}
```

Thêm code sau khi ```addNoteDialog.show()``` được gọi
```java
...
addNoteDialog.show();
FirebaseUserActions.getInstance().start(getNoteCommentAction());
```

> Best Practices for logging user actions on personal content
 * Truyền ```false``` vào function ```setUpload()``` của metadata builder để chắc chắn rằng những nội dung
cá nhân của người dùng chỉ được lưu trên device.



### Test Your Implementation

#### Handle Incoming Links

> $ adb shell am start -a android.intent.action.VIEW \
-d "http://recipe-app.com/recipe/pierogi-poutine" com.packagename.recipe_app


#### Public Content and User Actions
 1. Sử  dụng Google app, tìm kiếm Pierogi Poutine. 
 
 2. Verify that the app can be discovered through the Google app with autocomplete as shown above.

 3. Leave the app open for the next step.

 
#### Personal Content and User Actions
 
 <i>Thêm persional content</i>
 <i>Xoá persional content</i>
