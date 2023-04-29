rm -rf merge
mkdir merge

for d in */ ; do
	echo $d
    	if [ -f "$d\build.sh" ]; then
        	echo CALL: $d/build.sh
        	cd $d
        	./build.sh
        	cd ..
   	fi
done

cd merge
mkdir temp

for f in *.jar ; do
	echo $f
    	cd temp
	jar -xf ../$f
	cd ..
done

cd temp
jar -cvf ../UnikAPI.jar *
cd ..
cd ..

echo Build finished!
