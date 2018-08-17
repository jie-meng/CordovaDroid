cordova.define("cordova-plugin-appinfo.appinfo", function(require, exports, module) {

var argscheck = require('cordova/argscheck');
var channel = require('cordova/channel');
var utils = require('cordova/utils');
var exec = require('cordova/exec');
var cordova = require('cordova');

channel.createSticky('onCordovaInfoReady');
// Tell cordova channel to wait on the CordovaInfoReady event
channel.waitForInitialization('onCordovaInfoReady');

class AppInfo {
    constructor() {
        this.name = undefined;
        this.versionName = undefined;
        this.init()
    }

    init() {
        let _this = this;
        channel.onCordovaReady.subscribe(() => {
                    _this.getInfo(info => {
                        _this.name = info.name;
                        _this.versionName = info.versionName;
                        channel.onCordovaInfoReady.fire();
                    });
                }, null);
    }

    getInfo(successCallback, errorCallback) {
        exec(successCallback, errorCallback, 'AppInfo', 'getAppInfo');
    }
}

module.exports = new AppInfo();

});