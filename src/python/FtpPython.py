import os
import configparser
from ftplib import FTP

PATH = "./ftpInfo.ini"
CONF = configparser.ConfigParser()
ftp = FTP()
SECTION1 = 'section1'


def parseConfig():
    CONF.read(PATH);


def ftpConnect():
    ftp.connect(CONF.get(SECTION1, "host"), int(CONF.get(SECTION1, "port")))
    ftp.login(CONF.get(SECTION1, "username"), CONF.get(SECTION1, "password"))
    print(ftp.getwelcome())


def ftpDownload():
    source = CONF.get(SECTION1, "download_source")
    target = CONF.get(SECTION1, "download_target")
    file_handle = open(target, 'wb').write
    ftp.retrbinary("RETR %s" % (source), file_handle)


def ftpUpload():
    source = CONF.get(SECTION1, "upload_source")
    target = CONF.get(SECTION1, "upload_target")
    file_handle = open(source, 'rb')
    ftp.storbinary("STOR %s" % (target), file_handle)


parseConfig()
ftpConnect()
a = input("请输入使用方式 1: 下载 2: 上传:")
if a == '1':
    print("开始下载")
    ftpDownload()
    print("下载成功")
elif a == '2':
    print("开始上传")
    ftpUpload()
    print("上传成功")
else:
    print("输入错误")

# parseConfig();
# ftp.connect("192.168.27.1", 21)
# ftp.login()
# print(ftp.getwelcome())
# filename='F:\\robots.txt'
# file_handle=open(filename, 'wb').write
# print(ftp.nlst())
# print(ftp.pwd())
# ftp.retrbinary("RETR robots.txt", file_handle)
# ftp.quit()
