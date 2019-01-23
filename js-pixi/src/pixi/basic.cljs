(ns pixi.basic
	(:require cljsjs.pixi))

(defonce app (js/PIXI.Application. 800 600 #js {:backgroundColor 0x1099bb}))

(defn load-app []
	(let [app-dom (.getElementById js/document "app")
		  skull (js/PIXI.Sprite.fromImage "assets/img/skull2.png")
		  stage (.-stage app)
		  ticker (.-ticker app)]
		(.appendChild app-dom (.-view app))
		(.addChild stage skull)
		(.set (.-anchor skull) 0.5)
		(set! (.-x skull) (/ (aget app "screen" "width") 2))
		(set! (.-y skull) (/ (aget app "screen" "height") 2))
		(.add ticker (fn [d] 
			(set! (.-rotation skull) (+ (.-rotation skull) (* 0.01 d)))))))

(load-app)

; var app = new PIXI.Application(800, 600, {backgroundColor : 0x1099bb});
; document.body.appendChild(app.view);

; // create a new Sprite from an image path
; var bunny = PIXI.Sprite.fromImage('required/assets/basics/bunny.png')

; // center the sprite's anchor point
; bunny.anchor.set(0.5);

; // move the sprite to the center of the screen
; bunny.x = app.screen.width / 2;
; bunny.y = app.screen.height / 2;

; app.stage.addChild(bunny);

; // Listen for animate update
; app.ticker.add(function(delta) {
;     // just for fun, let's rotate mr rabbit a little
;     // delta is 1 if running at 100% performance
;     // creates frame-independent transformation
;     bunny.rotation += 0.1 * delta;
; });
