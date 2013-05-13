value =  "this is validation file"
alert value
cofeeFunc = ->
  coffeeAns =  confirm "Ready for coffee?"
  ans = if coffeeAns then "Ready for Coffee " else "Not ready for Coffee "
  alert ans
