function onDeviceReady() {
    navigator.notification.alert('This is message', function() {}, 'Title', 'CLICK');
}
document.addEventListener("deviceready", onDeviceReady, false);