STATIC=index.html stardust.png icon.png server/* css/*
STATICSRC=$(foreach s,$(STATIC),public/$(s))

all: release release/data release/index.html release/js/app.js

release/index.html: $(STATICSRC)
	cd public && rsync -avz -R $(STATIC) ../release && touch ../release/index.html

release:
	mkdir -p release

release/data:
	mkdir -p release/data

release/js/app.js: src/starchart/*.cljs project.clj env/prod/cljs/starchart/prod.cljs
	lein package

.PHONY: clean

clean:
	rm -rf release
