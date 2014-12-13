(ns channel-demo.views.app
  (:require [hiccup.page :refer (html5 include-css include-js)]
            [hiccup.form]
            [hiccup.element :refer (link-to)]))

(defn board [game_link]
  (html5 {:ng-app "TicTacToe" :lang "en"}
         [:head
          [:script {:src "/_ah/channel/jsapi"}]
          [:title "TicTacToe"]
          (include-css "css/board.css")]

         [:body

          [:div {:id "display-area"}
           [:h2 "Channel-based Tic Tac Toe"]
           [:div {:id "other-player" :style "display:none"}
            "Waiting for another player to join."[:br]
            "Send them this link to play:"[:br]
            [:div {:id "game-link"}
             [:a {:href game_link} game_link]]]
           [:div {:id "your-move" :style "display:none"}
            "Your move! Click a square to place your piece."]
           [:div {:id "their-move" :style "display:none"}
            "Waiting for other player to move..."]
           [:div {:id "you-won"} "You won this game!"]
           [:div {:id "you-lost"} "You lost this game."]
           [:div {:id "board"}
            [:div {:class "t l cell"} [:table [:tr [:td {:id "0"}]]]]
            [:div {:class "t c cell"} [:table [:tr [:td {:id "1"}]]]]
            [:div {:class "t r cell"} [:table [:tr [:td {:id "2"}]]]]
            [:div {:class "m l cell"} [:table [:tr [:td {:id "3"}]]]]
            [:div {:class "m c cell"} [:table [:tr [:td {:id "4"}]]]]
            [:div {:class "m r cell"} [:table [:tr [:td {:id "5"}]]]]
            [:div {:class "b l cell"} [:table [:tr [:td {:id "6"}]]]]
            [:div {:class "b c cell"} [:table [:tr [:td {:id "7"}]]]]
            [:div {:class "b r cell"} [:table [:tr [:td {:id "8"}]]]]]
           [:div {:id "this-game" :float "top"}
            "Quick link to this game: "
            [:span {:id "this-game-link"}
             [:a {:href game_link} game_link ]]]]

          (include-js "js/board.js")
          ]))
