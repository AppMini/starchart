(ns starchart.core
    (:require
      [reagent.core :as r]))

(def colors ["#F80000" "#F77900" "#F6E800" "#00F700" "#007EF9" "#7E00F9"])
(def number-colors ["#fff" "#333" "#333" "#333" "#fff" "#fff"])

(defn star [r]
  [:svg
   {:viewBox "0 0 560 560"
    :y "0px"
    :x "0px"
    :width "100px"
    :height "100px"
    :class "icon-star"}
   [:defs
     [:filter {:id "glowfilter" :x "-24" :y "-24" :width "560" :height "560"
            :dangerouslySetInnerHTML
            {:__html "<feGaussianBlur in='SourceGraphic' stdDeviation='16'/>
                      <feMerge>
                        <feMergeNode/><feMergeNode in='SourceGraphic'/>
                      </feMerge>"}}]]
   [:g {:transform "translate(24,24)"}
    [:path
     {:d
      (str "M215.906,35.272C223.438,20.006,238.984,10.35,256,10.35s32.563,9.656,40.094,24.922l44.484,90.141"
           "c6.516,13.188,19.094,22.344,33.656,24.453l99.484,14.453c16.844,2.453,30.828,14.25,36.094,30.438"
           "c5.266,16.172,0.875,33.953-11.313,45.828l-71.984,70.156c-10.531,10.281-15.344,25.078-12.859,39.578l17,99.062"
           "c2.875,16.781-4.031,33.734-17.797,43.734s-32.016,11.313-47.078,3.406l-88.984-46.781c-13.016-6.844-28.578-6.844-41.609,0"
           "l-88.969,46.781c-15.063,7.906-33.313,6.594-47.078-3.406c-13.781-10-20.672-26.953-17.797-43.734l17-99.062"
           "c2.484-14.5-2.328-29.297-12.859-39.578L13.5,240.584C1.313,228.709-3.078,210.928,2.188,194.756"
           "c5.266-16.188,19.25-27.984,36.094-30.438l99.484-14.453c14.547-2.109,27.141-11.266,33.656-24.453L215.906,35.272z")
      :fill (get colors (mod r (count colors)))
      :filter "url(#glowfilter)"}]
    [:text {:x "256" :y "320"
            :text-anchor "middle" 
            :font-size "128" 
            :font-family "Arial" 
            :fill (get number-colors (mod r (count number-colors))) 
            :stroke (get number-colors (mod r (count number-colors))) 
            :stroke-width "12" 
            :stroke-linejoin "round" 
            :stroke-linecap "round"} r]]])

;; -------------------------
;; Views

(defn home-page [starcount]
  [:div#star-container (for [r (range @starcount)] (with-meta [star r] {:key r}))])

;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render [home-page (atom 50)] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
