(ns name.alyssackwan.census.main
  (:require [hiccup.core :as hcp-core]
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

(defn not-found []
  "<h1>Page not found.</h1>")

(cpj-core/defroutes app
  (cpj-core/GET "/" [] (index))
  (cpj-rt/files "/")
  (cpj-rt/not-found (not-found)))

(defonce server
  (ring-jty/run-jetty #'app
                      {:port 8080
                       :join? false}))

(defn -main [& args]
  (.start server))
