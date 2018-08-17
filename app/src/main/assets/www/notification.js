function onDeviceReady() {
    navigator.notification.alert(navigator.appinfo.versionName, function() {}, navigator.appinfo.name, 'CLICK');
}
document.addEventListener("deviceready", onDeviceReady, false);