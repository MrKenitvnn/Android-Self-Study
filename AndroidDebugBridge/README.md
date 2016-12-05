

> Di chuyển tới thư mục platform-tools để sử dụng adb
```
cd /Users/HN/Library/Android/sdk/platform-tools/
```

* Window: adb
* OSX: ./adb


### ADB Debugging

> - Hiển thị tất cả emulator/device đã kết nối
```
adb devices
```

> - Forward socket connections
```
$> adb forward <local> <remote>
// adb forward tcp:8000 tcp:9000 set up forwarding of host port 8000 to emulator/device port 9000
```

> - Terminates the adb server process
```
$> adb kill-server
```


### Wireless

> - Sử dụng adb qua Wi-fi
```
Bước 1: Kết nối tới device bằng USB.
Bước 2: Hiện tất cả các devices đang được kết nối 
$> adb devices
Bước 3: Thiết lập kết nối qua port 5555
$> adb tcpip 5555
Bước 4:  
Xem địa chỉ IP của device: Settings -> About -> Status -> IP address. 
$> adb connect #.#.#.#:5555
```

> - Khởi động lại adb trong chế độ kết nối USB.
```
$> adb usb 
```


### Package Manager

> - Cài đặt 1 ứng dụng với file .apk
```
$> adb install [option] "path/to/app.apk"
```

> - Gỡ ứng dụng
```
$> adb uninstall [options] <PACKAGE>
$> adb uninstall -k com.test.app :Vẫn giữ lại data và folder cache sau khi gỡ ứng dụng. 
```

> - In ra tất cả các packages trong device
```
adb shell pm list packages [options] <FILTER>
```


### File Manager

> - Copy file từ điện thoại sang máy tính 
```
$> adb pull /file/on/phone.txt ~/Documents/phone.txt
```

> - Copy file từ máy tính sang điện thoại 
```
$> adb push /file/on/your/computer.txt /path/to/your/phone/computer.txt
```



### Network


### Logcat
> - Hiện log trong command 
```
$> adb logcat [option] [filter-specs]
Example: filter to only show Error level
$> adb logcat *:E 
```


### Screenshot

### System





> Nguồn
<br/>- http://adbshell.com/
<br/>- http://www.vogella.com/tutorials/AndroidCommandLine/article.html

