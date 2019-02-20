(ns web-re-frame.inventory.view)

(defn inventory-panel
  []
  (let []
    [:div
     [:h2 "[Inventory]"]
     [:div {:id "spaces"}
      [:div {:on-click #(println "CLICK")}
       "Add space"]]

     ;-----------------------
     [:div
      [:a {:href "#/"}
       "go back to Home Page"]]]))