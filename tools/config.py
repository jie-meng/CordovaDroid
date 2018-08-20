# -*- coding: utf-8 -*-

class Config(object):

    def __init__(self, app_type, api_token, app_id):
        self.__app_type = app_type
        self.__api_token = api_token
        self.__app_id = app_id

    def getAppType(self):
        return self.__app_type

    def getApiToken(self):
        return self.__api_token

    def getAppId(self):
        return self.__app_id