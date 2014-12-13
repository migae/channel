(defproject channel-demo "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :pom-location "/dev/null/"

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.8"]
                 [clj-http "1.0.0"] ;; http client lib
                 [org.clojure/tools.logging "0.3.0"]
                 [org.clojure/clojurescript "0.0-2411"]]
                 ;; [org.clojure/clojurescript "0.0-2197"]]

  :source-paths ["src/clj"]

  :cljsbuild {
    :builds [{:id "webapp"
              :source-paths ["src/main/cljs"]
              :compiler {
                :output-to ~(str "target/channel-demo-0.1.0-SNAPSHOT/js/main.js")
                :output-dir ~(str "target/channel-demo-0.1.0-SNAPSHOT/js/")
                :optimizations :none
                :source-map true}}]}
                ;; :output-to "src/main/webapp/resources/public/js/main.js"
                ;; :output-dir "src/main/webapp/resources/public/js/"
                ;; :output-to "resources/public/js/main.js"
                ;; :output-dir "resources/public/js/"

  :hooks [leiningen.cljsbuild]

  :plugins [[lein-ring "0.8.13"]
            [lein-cljsbuild "1.0.3"]]
            ;; [lein-cljsbuild "1.0.4-SNAPSHOT"]]

  :ring {:handler webapp.core/app}

  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
