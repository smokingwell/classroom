@rem 用来设置笔记本双网卡静态路由
@rem 固定网卡 用于访问公司内网 网关:10.158.208.1
@rem 无线网卡 网关用于访问实验室网络 1楼热点网关172.18.119.254 4楼热点网关:192.168.99.254

echo off

if "%1" ==""  goto :floor4route
@rem 添加BBA 1楼路由
route delete 0.0.0.0 mask 0.0.0.0 172.18.119.254
route add 172.18.0.0 mask 255.255.0.0 172.18.119.254
goto :finish

:floor4route
@rem 添加BBA 4楼路由
route delete 0.0.0.0 mask 0.0.0.0 192.168.99.254
route add 172.18.0.0 mask 255.255.0.0 192.168.99.254
goto :finish

:finish
