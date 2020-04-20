(ns lambdaisland.chui.styles
  (:require [garden.core :as garden]
            [garden.stylesheet :as stylesheet]
            [garden.selectors :as selectors]))

(def washed-red "#FFDFDF")
(def washed-green "#E8FDF5")

(selectors/defselector input)

(def search-input (partial input (selectors/attr= "type" "search")))

(def style
  [[:* {:box-sizing "border-box"}]
   [:html {:color "#333"
           :font-family "sans-serif"
           :height "100vh"}]
   [:body {:margin 0
           :height "100%"}]
   [:#app {:height "100%"}
    [:> [:div {:height "100%"
               :display :grid
               :grid-template-rows "auto 1fr"
               :grid-gap ".3rem"
               :padding ".3rem"}]]]
   [:header {:background-color "#6b6bff"
             :color "#7cdfff"
             :padding ".3rem"
             :border-radius ".1rem"
             :display :flex
             :justify-content :space-between}]
   [:.interface-controls {:display :flex}]
   [:ul {:padding ".2rem"
         :list-style :none
         :text-decoration :none
         :line-height 1.5}]
   [:li [:a {:text-decoration :none}]]
   [:main
    {:display :flex
     :width "100%"
     :overflow-x "auto"
     :scroll-snap-type "x mandatory"
     :scrollbar-width :none
     :background-color :initial}
    [:&.cols-2 [:>section {:width "calc(100vw / 3)"}]]
    [:&.cols-3
     [:>section {:flex 1}
      [:&:last-child {:flex 2}]]]
    [:&.cols-4
     [:>section {:width "20vw"}
      [:&:last-child {:width "40vw"}]]]
    [:>section {:flex-shrink 0
                :scroll-snap-align :center
                :scrollbar-width :none
                :display :flex
                :flex-direction :column
                :padding ".5rem"
                :overflow "scroll"}
     [:&:hover {:background-color :snow}]]]
   [:.namespaces {:background-color :inherit}]
   [:.fieldset {:border "1px solid black"
                :margin-top ".3rem"
                :margin-bottom ".3rem"}]
   [(search-input)
    {:padding ".5rem"
     :border "none"
     :width "100%"
     :font-size "1.1rem"
     :line-height 1.5}]
   [(search-input "::placeholder") {:color :gray}]

   [:.selection-target
    [:&:hover {:background-color "#ff8"}]
    [:&.selected {:background-color "#cfc"}]]
   [:.history { :background-color :inherit}]
   [:.section-header {:font-size "1.1rem"
                      :font-weight "bold"
                      :width "100%"
                      :border-bottom "1px solid #000"
                      :margin 0}]
   [:.test-info { :background-color :initial}]
   [:.namespaces [:+ul {:padding-left "1.5rem"
                        :line-height "1.7rem"}]]
   [:.name {:color :white
            :text-decoration :none
            :padding-right ".3rem"}]
   [:.toggle {:position :absolute
              :left "-100vw"}]
   [:.namespace-selector {:display :flex
                          :flex-direction :column
                          :margin-top ".5rem"
                          :line-height 1.125}]
   [:.active {:font-weight :bold}]
   [:.search-bar {:display :grid
                  :background-color :whitesmoke
                  :box-shadow "1px 1px 5px whitesmoke"
                  :grid-template-columns "1fr 22%"
                  :grid-auto-flow :column
                  :border "1px solid whitesmoke"
                  :position :sticky
                  :top 0}]
   [:.button {:font-variant-caps :all-small-caps
              :font-weight :bold
              :background-color :inherit
              :border :none
              :font-size "1.1rem"}
    [:&:hover {:color :white
               :cursor :pointer}]]
   [:.run-tests {:color :silver
                 :line-height ".9"}
    [:&:hover :&:active {:background-color :lightgreen}]]
   [:.stop-tests {:color :coral}
    [:&:hover {:background-color :lightcoral}]]
   [:.namespace-links
    {:font-size "1rem"
     :display :flex
     ;; :flex-flow "column wrap"
     :justify-content :space-between
     :border-radius "2px"}
    [:* {}
     [:&:selected {:background-color :fuchsia}]]
    [:input {:display :none
             :width :max-content}]
    [:label {:padding ".50rem .5rem"
             :flex 1}]
    [:aside {:padding ".50rem .5rem"}]
    [:small {:font-style :italic
             :color :darkgray
             :white-space :nowrap}]
    [:.skip {:color :darkgray}]]
   [:.result-viz
    [:.ns {:border "1px solid #113"
           :border-radius "4px"
           :margin-right "3px"
           :overflow-wrap :break-word
           :line-height "2rem"}]
    [:.var {:border-right "1px solid #113"}
     [:&:first-child {:border-radius "4px 0 0 4p"}]
     [:&:last-child {:border-style :none}]]
    [:.assertion
     {:font-variant-caps :all-small-caps
      :font-weight :bold
      :color :darkgray
      :padding "0 4px"}]
    [:.selected-ns
     [:.pass {:color :white :background-color :green}]
     [:.fail {:color :white :background-color :red}]
     [:.error {:color :white :background-color :red}]]
    [:.pass {:background-color washed-green}]
    [:.fail {:background-color washed-red}]
    [:.error {:background-color washed-red}]]
   
   [:.ns-run-var
    [:.result-viz-var

     [:.assertion
      {:font-variant-caps :all-small-caps
       :font-weight :bold
       :color :darkgray
       :padding "0 4px"}]
     [:.pass {:color :white :background-color :green}]
     [:.fail {:color :white :background-color :red}]
     [:.error {:color :white :background-color :red}]]]

   [:.run
    {:display :grid
     :grid-template-columns "1fr auto"
     :grid-template-rows "auto auto auto"
     :border "1px solid whitesmoke"
     :box-shadow "1px 1px 5px whitesmoke"
     :margin-bottom "1rem"}
    [:p {:margin 0}]
    [:.run-header {:padding ".5rem 1rem"
                   :grid-column-start 1
                   :background-color :initial ;fix
                   :color "#333"              ;fix
                   :border-radius :initial    ;fix
                   :justify-content :initial  ;fix
                   :grid-column-end 3
                   :display :grid
                   :grid-template-columns :subgrid}
     [:p {:grid-column-start 1}]
     [:small {:grid-column-start 2
              :color :gray}]]
    [:footer {:padding ".5rem 1rem"
              :grid-column "1 /span 2"
              :grid-row-start 3}]
    [:progress {:grid-column "1 / span 2"
                :width "100%"
                :height "4px"
                :margin-top ".5rem"
                :margin-bottom ".5rem"}]]
   [:.test-results {:box-sizing :padding-box
                    :grid-column "1 / span 2"
                    :display :flex
                    :flex-wrap :wrap
                    :justify-content :flex-start
                    :margin "0 1rem"
                    :gap ".2rem"
                    :padding-top ".5rem"
                    :padding-bottom ".5rem"}]
   [:.var {:display :inline-flex
           :margin-right ".2rem"
           :border "1px solid darkslategray"
           :padding "1px"
           :width :inherit
           :height :inherit}]
   [:output {:width ".2rem"
             :height "1rem"}
    [:.pass {:background-color "#29908a"}]
    [:.fail {:background-color "#fce840"}]
    [:.error {:background-color "#fce840"}]]
   [:.ns-run
    {:border "1px solid whitesmoke"
     :box-shadow "1px 1px 5px whitesmoke"
     :padding ".5rem 1rem"
     :width :max-content
     :font-family :sans-serif
     :display :grid
     :grid-gap ".5rem"}
    [:.ns-run--header
     {:background-color :initial
      :color :inherit
      :padding :none
      :border-radius :none
      :display :initial
      :justify-content :none}
     [:h2 {:font-weight :normal
           :margin-bottom ".2rem"
           :font-size "1.1rem"}]
     [:.filename {:color :darkslategray
                  :font-size ".8rem"
                  :font-family :monospace}]]
    [:>div {:display :flex
            :flex-direction :column
            :gap ".5rem"}]
    [:.ns-run-var
     {:border "1px solid whitesmoke"}
     [:header
      {:background-color :initial
       :color :inherit
       :padding 0
       :border-radius :unset
       :line-height 1.5
       :display :flex}
      [:h3 {:font-weight :normal
            :font-size "1rem"
            :padding-left ".2rem"}]
      [:p {:padding-right ".4rem"}]]
     [:h4 {:font-weight :normal
           :font-size ".8rem"
           :padding-right ".2rem"}]]
    [:.fail {:border-right "4px solid #fce840"}]
    [:.error {:border-right "4px solid tomato"}]
    [:.success {:border-right "4px solid #29908a"}]
    [:h2 :h3 :h4 :p {:margin 0}]
    [:code {:font-family :monospace
            :padding ".2rem"}]
    [:.actual {:color :red
               :font-weight :bold}]]])

(defmacro inline []
  (garden/css {:pretty-print? false} style))
