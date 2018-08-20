# -*- coding: utf-8 -*-

import sys
import os
import json
import subprocess

class HockeyApp(object):

    def __init__(self, api_token, app_id):
        self.__api_token = api_token
        self.__app_id = app_id

    def getCurrentVersion(self):
        result = subprocess.check_output('curl -H "X-HockeyAppToken: %s" "https://rink.hockeyapp.net/api/2/apps/%s/app_versions"' % (self.__api_token, self.__app_id), shell=True)
        hockeyapp_info = json.loads(result)
        if len(hockeyapp_info['app_versions']) == 0:
            return 0
        else:
            return int(hockeyapp_info['app_versions'][0]['version'])

    def getNextVersion(self):
        return self.getCurrentVersion() + 1
