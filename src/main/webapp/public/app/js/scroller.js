$(document).ready(function(){
    $( window ).scroll(function () {if ($(this).scrollTop() > 300) {$('#scroller').fadeIn();} else {$('#scroller').fadeOut();}});
    $('body').append ('<a id="scroller" class="to-top hidden-sm hidden-xs" style="display: none;"><span id="but" class="to-top-button">to top</span></a>');
    $('#scroller').click (function () {$('body, html').animate ({scrollTop: 0}, 400); return false;});
});