rm -rf merge
mkdir merge

for d in */ ; do
    if [ -f "$d\build.bat" ]; then
        echo CALL: $d/build.bat
        cd $d
        ./build.bat
        cd ..
    fi
done

cd merge
mkdir temp

for f in *.jar ; do
    cd temp
	jar -xf ../$f
	cd ..
done

cd temp
jar -cvf ../UnikAPI.jar *
cd ..
cd ..

echo Build finished!