@echo off   
 
rmdir /s /q merge
mkdir merge

for /D %%f in (*) do (
	if exist %%f/build.bat (
    		echo CALL: %%f/build.bat
		cd %%f
		call build.bat
		cd ..
	)
)

cd merge
mkdir temp

for %%f in (*.jar) do (
	echo %%f
	cd temp
	jar -xf ..\%%f
	cd ..
)

cd temp
jar -cvf ..\UnikAPI.jar *
cd ..
cd ..

echo Build finished!
pause