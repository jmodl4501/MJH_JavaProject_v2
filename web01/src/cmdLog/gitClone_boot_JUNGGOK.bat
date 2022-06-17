rmdir D:\Project\MJH_JavaProject_v2 /s /q
D:
cd D:\Project
git init D:\Project
git clone https://github.com/jmodl4501/MJH_JavaProject_v2.git
cd D:\Project\MJH_JavaProject_v2
chcp 65001
if exist D:\Project\MJH_JavaProject_v2\web01\src\cmdLog\%date:-=%^_JUNGGOK.txt (
	echo %date% %time%^>fileUpdate>>D:\Project\MJH_JavaProject_v2\web01\src\cmdLog\%date:-=%^_JUNGGOK.txt
) else (
	echo %date% %time%^>fileCreate>D:\Project\MJH_JavaProject_v2\web01\src\cmdLog\%date:-=%^_JUNGGOK.txt
)
git init D:\Project\MJH_JavaProject_v2
git add .
git commit -m "%date% %time%"
git push origin master