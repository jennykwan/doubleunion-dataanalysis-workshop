(ns name.alyssackwan.census.main-test
  (:use midje.sweet
        name.alyssackwan.census.main)
  (:require [ring.mock.request :as mock-rq]))

(fact "root loads index"
  (let [rq (mock-rq/request :get "/")
        res (app rq)]
    (:status res) => 200
    (:body res) => (index)))

(fact "/js/index.js loads"
  (let [rq (mock-rq/request :get "/js/index.js")
        res (app rq)]
    (:status res) => 200
    (:body res) => (java.io.File. "public/js/index.js")))

(fact "/js/us.json loads"
  (let [rq (mock-rq/request :get "/js/us.json")
        res (app rq)]
    (:status res) => 200
    (:body res) => (java.io.File. "public/js/us.json")))
