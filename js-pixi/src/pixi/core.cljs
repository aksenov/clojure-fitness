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

