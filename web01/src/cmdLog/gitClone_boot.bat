rmdir D:\Project\MJH_JavaProject_v2 /s /q
rmdir D:\Project\JavaWebProgramming /s /q
D:
cd D:\Project
git init D:\Project
git clone https://github.com/jmodl4501/MJH_JavaProject_v2.git
git clone https://github.com/eomjinyoung/JavaWebProgramming.git
cd D:\Project\MJH_JavaProject_v2
chcp 65001
echo %date% %time%^>파일생성> D:\Project\MJH_JavaProject_v2\web01\src\cmdLog\%date%.txt
pause
git init D:\Project\MJH_JavaProject_v2
git add .
git commit -m "%date% %time%"
git push origin master
pause