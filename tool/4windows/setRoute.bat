@rem �������ñʼǱ�˫������̬·��
@rem �̶����� ���ڷ��ʹ�˾���� ����:10.158.208.1
@rem �������� �������ڷ���ʵ�������� 1¥�ȵ�����172.18.119.254 4¥�ȵ�����:192.168.99.254

echo off

if "%1" ==""  goto :floor4route
@rem ���BBA 1¥·��
route delete 0.0.0.0 mask 0.0.0.0 172.18.119.254
route add 172.18.0.0 mask 255.255.0.0 172.18.119.254
goto :finish

:floor4route
@rem ���BBA 4¥·��
route delete 0.0.0.0 mask 0.0.0.0 192.168.99.254
route add 172.18.0.0 mask 255.255.0.0 192.168.99.254
goto :finish

:finish
