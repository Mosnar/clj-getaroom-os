(defproject getaroom "0.1.0-SNAPSHOT"
  :description "GetARoom"
  :url "http://getaroom.io/"
  :license {:name "GNU General Public License v2.0"
            :url  "http://www.gnu.org/licenses/old-licenses/gpl-2.0.en.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]              ; Used for clojure, lol
                 [clj-time "0.10.0"]                        ; Will be used for time stuff??
                 [http-kit "2.1.18"]                        ; Used for http client/server
                 [ring/ring-core "1.4.0"]
                 [ring/ring-jetty-adapter "1.4.0"]
                 [compojure "1.4.0"]                        ; Used for routing http server
                 [cheshire "5.5.0"]                         ; Used for json parsing
                 [sonian/carica "1.1.0"]                    ; Used for config
                 [org.apache.commons/commons-daemon "1.0.9"]] ; Used for daemonizing

  :main ^:skip-aot getaroom.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
