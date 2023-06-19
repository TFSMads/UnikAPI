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
	cd temp
	jar -xf ..\%%f
	cd ..
)

cd temp
mkdir "%~dp0/merge/temp/addonJson/laby4"
move /Y addon.json, "%~dp0/merge/temp/addonJson/laby4/"
jar -cvf ..\UnikAPI.jar *
cd ..
cd ..

echo Build finished!