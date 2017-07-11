
>Chú ý: update Google play services 10.0.1 trở lên, Android Studio 1.5 trở lên

### Thêm SDK 

<b>build.gradle của project</b>
```php
dependencies {
  ...
  // To avoid errors, use the same Firebase SDK version across your app.
  classpath 'com.google.gms:google-services:3.0.0'
  ...
}
```

<b>build.gradle của app</b>
```php
apply plugin: 'com.android.application'

android {
  // ...
}

dependencies {
  // ...
  compile 'com.google.firebase:firebase-core:10.0.1'
  
  // Getting a "Could not find" error? Make sure you have
  // the latest Google Repository in the Android SDK manager
}

// ADD THIS AT THE BOTTOM
apply plugin: 'com.google.gms.google-services'
```

<b>Thêm dịch vụ muốn sử dụng</b>
<table>
<thead>
<tr>
<th>Gradle Dependency Line</th>
<th align="center">Service</th>
</tr>
</thead>
<tbody>
<tr>
<td>com.google.firebase:firebase-core:10.0.1</td>
<td align="center">Analytics</td>
</tr>
<tr>
<td>com.google.firebase:firebase-database:10.0.1</td>
<td align="center">Realtime Database</td>
</tr>
<tr>
<td>com.google.firebase:firebase-storage:10.0.1</td>
<td align="center">Storage</td>
</tr>
<tr>
<td>com.google.firebase:firebase-crash:10.0.1</td>
<td align="center">Crash Reporting</td>
</tr>
<tr>
<td>com.google.firebase:firebase-auth:10.0.1</td>
<td align="center">Authentication</td>
</tr>
<tr>
<td>com.google.firebase:firebase-messaging:10.0.1</td>
<td align="center">Cloud Messaging and Notifications</td>
</tr>
<tr>
<td>com.google.firebase:firebase-config:10.0.1</td>
<td align="center">Remote Config</td>
</tr>
<tr>
<td>com.google.firebase:firebase-invites:10.0.1</td>
<td align="center">Invites and Dynamic Links</td>
</tr>
<tr>
<td>com.google.firebase:firebase-ads:10.0.1</td>
<td align="center">AdMob</td>
</tr>
<tr>
<td>com.google.firebase:firebase-appindexing:10.0.1</td>
<td align="center">App Indexing</td>
</tr>
</tbody>
</table>
