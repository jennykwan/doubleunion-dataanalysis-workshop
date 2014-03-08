(ns name.alyssackwan.census.main
  (:require [name.alyssackwan.census.data :as data]
            [hiccup.core :as hcp-core]
            [clojure.data.json :as dat-json]
            [compojure.core :as cpj-core]
            [compojure.route :as cpj-rt]
            [ring.adapter.jetty :as ring-jty])
  (:gen-class))

(defn index []
  (hcp-core/html
   [:head
    [:title "United States"]]
   [:body
    [:script {:src "http://d3js.org/d3.v3.min.js"}]
    [:script {:src "http://d3js.org/topojson.v1.min.js"}]
    [:script {:src "/js/index.js"}]]))

(defn data-index []
  (hcp-core/html
   [:head
    [:title "United States County Data"]]
   [:body
    (dat-json/write-str data/income-and-poverty-01)]))

(defn not-found []
  "<h1>Page not found.</h1>")

(cpj-core/defroutes app
  (cpj-core/GET "/" [] (index))
  (cpj-core/GET "/data" [] (data-index))
  (cpj-rt/files "/")
  (cpj-rt/not-found (not-found)))

(defonce server (atom nil))

(defn start [port]
  (swap! server (fn [value]
                  (if (nil? value)
                    (ring-jty/run-jetty #'app {:port port :join? false})
                    value))))

(defn -main [& args]
  (start 3000))
