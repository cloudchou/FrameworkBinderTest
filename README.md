在框架层使用BinderService的示例

BServer下的代码将生成bserver 和 bserver.jar程序，作为BinderService的服务端

BClient下的代码将生成bclient 和 bclient.jar程序，作为BinderService的client端，测试BinderService服务端

编译好后可使用如下命令来测试

adb bserver.jar /system/framework && adb push bserver /system/bin/ && adb shell chmod 755 /system/bin/bserver

adb bclient.jar /system/framework && adb push bclient /system/bin/ && adb shell chmod 755 /system/bin/bclient


