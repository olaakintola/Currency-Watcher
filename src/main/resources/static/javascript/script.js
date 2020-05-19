

$.getJSON(
	"https://min-api.cryptocompare.com/data/pricemulti?fsyms=ETH,DASH&tsyms=BTC,USD,EUR&api_key=088509e9d87298ed3da6e360e9b21ee3b78abf70109e1c640ac0e6b3b5a4a223",
	function(data) {
	console.log(data);

	var price_btc = data.ETH.BTC;
	var price_eur = data.ETH.EUR;
	var price_usd = data.ETH.USD;

	// $(".price_btc").attr("src",price_btc);
	$(".price_btc").append(price_btc);
	$(".price_eur").append(price_eur);
	$(".price_usd").append(price_usd);
});