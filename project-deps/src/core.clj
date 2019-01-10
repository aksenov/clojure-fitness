(ns core
  (:require [clojure.core.async :as async]))

(defn -main [& args]
  (async/go
    (prn "ASYNC HELL HERE"))
  (prn "END HELL HERE"))
