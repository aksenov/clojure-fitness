(ns web-re-frame.views
  (:require
   [re-frame.core :as re-frame]
   [web-re-frame.subs :as subs]
   [web-re-frame.events :as events]
   [web-re-frame.inventory.view :as inventory-view]
   ))


;; home

(defn home-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1 (str "Hello from " @name ". This is the Home Page.")]

     [:div
      [:input {:type  "text"
               :value @(re-frame/subscribe [::subs/name])
               :on-change #(re-frame/dispatch [::events/set-name (-> % .-target .-value)])
               }]]
     ;-------------------------------
     [:div
      [:a {:href "#/about"}
       "go to About Page"]]
     [:div
      [:a {:href "#/inventory"}
       "go to Inventory Page"]]
     ]))


;; about

(defn about-panel []
  [:div
   [:h1 "This is the About Page."]

   [:div
    [:a {:href "#/"}
     "go to Home Page"]]])


;; main

(defn- panels [panel-name]
  (case panel-name
    :home-panel [home-panel]
    :about-panel [about-panel]
    :inventory-panel [inventory-view/inventory-panel]
    [:div]))

(defn show-panel [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    [show-panel @active-panel]))
