(ns pixi.core
	(:require cljsjs.pixi))

(def asset-loader js/PIXI.loader)

(println "Hello world!")

(defonce container (js/PIXI.Container.))

(defonce renderer
         (.autoDetectRenderer 
           js/PIXI 600 400
           #js {:view (.getElementById js/document "game-canvas")}))

(def white-text (js/PIXI.TextStyle. #js {:fontSize 36 
										 :fill #js ["red" "#000000"]}))
(def hello 
	(doto (js/PIXI.Text. "Hello world" white-text)
		(aset "x" 100)
		(aset "y" 200)))


(defn completed-loading-resources!
  [loader resources]
  (println "Resources loaded!")
  (let [skull (js/PIXI.Sprite. (aget resources "skull" "texture"))]
    (.addChild container skull)
    (.addChild container hello)
    (.render renderer container)))

(defn load-resources! []
  (-> (js/PIXI.loaders.Loader.)
      (.add "skull" "assets/img/skull2.png")
      (.load completed-loading-resources!)))

(load-resources!)

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
