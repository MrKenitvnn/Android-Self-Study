Nguồn: https://codelabs.developers.google.com/codelabs/app-indexing


- What you'll learn
 * Write personal app content to the on-device index
 * Log user actions for public and personal content
 
 
### Support Links For Your App Content

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
