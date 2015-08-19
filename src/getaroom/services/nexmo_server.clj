(ns getaroom.services.nexmo-server
  (:gen-class)
  (:use [compojure.core]
        [ring.adapter.jetty]
        [compojure.handler :only [site]]
        [compojure.route :only [files not-found]]
        [carica.core]
        [getaroom.dto.sms]
        )
  (:require
    [cheshire.core :as json]
    [org.httpkit.server :refer [run-server]])
  (:import (getaroom.dto.sms SMS)))

(defn index-handler [req]
  "Plz leaf"
  )

(defn nexmo-handler [req]
  (let [[msg-type msg-to msg-msisdn msg-messageId msg-message-timestamp msg-text :as sms-data]
        [(-> req :params :type)
         (-> req :params :to)
         (-> req :params :msisdn)
         (-> req :params :messageId)
         (-> req :params :message-timestamp)
         (-> req :params :text)
         ]
        ]
    (def msg (SMS. :type :to :msisdn :messageId :message-timestamp :text))
    (print :text msg)
    ))

(defroutes all-routes
           (GET "/" [] index-handler)
           (GET "/api/v1/nexmo" {params :params} nexmo-handler)
           (not-found "<h1>cya l8r g8r</h1>"))

(defn start-server []
  (run-server (site #'all-routes) {:port (config :http :server :port)})
  )
