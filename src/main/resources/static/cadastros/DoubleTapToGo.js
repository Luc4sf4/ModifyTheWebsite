/*
	By Osvaldas Valutis, www.osvaldas.info
	Available for use under the MIT License  
  More informations:
  https://osvaldas.info/drop-down-navigation-responsive-and-touch-friendly
*/
;(function( $, window, document, undefined )
{
	$.fn.doubleTapToGo = function( params )
	{
		if( !( 'ontouchstart' in window ) &&
			!navigator.msMaxTouchPoints &&
			!navigator.userAgent.toLowerCase().match( /windows phone os 7/i ) ) return false;
		this.each( function()
		{
			var curItem = false;
			$( this ).on( 'click', function( e )
			{
				var item = $( this );
				if( item[ 0 ] != curItem[ 0 ] )
				{
					e.preventDefault();
					curItem = item;
				}
			});
			$( document ).on( 'click touchstart MSPointerDown', function( e )
			{
				var resetItem = true,
					parents	  = $( e.target ).parents();
				for( var i = 0; i < parents.length; i++ )
					if( parents[ i ] == curItem[ 0 ] )
						resetItem = false;
				if( resetItem )
					curItem = false;
			});
		});
		return this;
	};
})( jQuery, window, document );
$( '#nav li:has(ul)' ).doubleTapToGo();
/*
	VIEWPORT BUG FIX
	iOS viewport scaling bug fix, by @mathias, @cheeaun and @jdalton
*/
;(function(e){function o(){s.content="width=device-width,minimum-scale="+i[0]+",maximum-scale="+i[1];e.removeEventListener(n,o,true)}var t="addEventListener",n="gesturestart",r="querySelectorAll",i=[1,1],s=r in e?e[r]("meta[name=viewport]"):[];if((s=s[s.length-1])&&t in e){o();i=[.25,1.6];e[t](n,o,true)}})(document);