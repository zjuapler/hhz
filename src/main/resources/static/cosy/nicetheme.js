/*
            /$$
    /$$    /$$$$
   | $$   |_  $$    /$$$$$$$
 /$$$$$$$$  | $$   /$$_____/
|__  $$__/  | $$  |  $$$$$$
   | $$     | $$   \____  $$
   |__/    /$$$$$$ /$$$$$$$/
          |______/|_______/
================================
        Keep calm and get rich.
                    Is the best.

  	@Author: Dami
  	@Date:   2017-09-06 15:27:44
  	@Last Modified by:   Dami
  	@Last Modified time: 2018-01-04 21:23:34
*/


jQuery(document).ready(function ($) {
    if ('addEventListener' in document) {
        document.addEventListener('DOMContentLoaded', function () {
            FastClick.attach(document.body);
        }, false);
    }
    $(window).on('load', function () {
        $(".main-preloader").length && (
            $(".main-preloader").addClass("window-is-loaded"),
                setTimeout(function () {
                        $(".main-preloader").remove()
                    },
                    650))
    });
});

var $window,
    $html,
    $pageHeader,
    $pageHeader_height,
    $window_height,
    $window_width,
    $searchHeader,
    $searchHeader_height,
    $search_down,
    $search_down_title,
    $html_overlay;

function variables() {
    $window = $(window);
    $pageHeader = $(".nt-header");
    $searchHeader = $(".mobile-search");
    $search_down = $(".nt_search_inner_down");
    $search_down_title = $(".featured-search-title");
    $html_overlay = $('<div class="dialog_overlay"></div>');
    $window_height = $window.height();
    $window_width = $window.width();
    $pageHeader_height = $pageHeader.outerHeight();
    $searchHeader_height = $searchHeader.outerHeight();
    $searchDown_height = $search_down.outerHeight();
    $searchDown_title_height = $search_down_title.outerHeight(true);
};


/*
	Sticky Menu
	----------------------------------------------------
*/

function stickyHeader() {
    if ($pageHeader.is(".nt-header")) {
        var sticky = $('.nt-header'),
            scroll = $window.scrollTop();

        if (scroll > $pageHeader_height) {

            // sticky.addClass('fixed');
            //$pageWrapper.css("margin-top", $pageHeader_height);


        } else {
            // sticky.removeClass('fixed');
            //$pageWrapper.removeAttr("style");
        }
    }
};

function scrollTop() {
    var scroll = $window.scrollTop(),
        startPoint = $window_height / 2,
        scrTopBtn = $(".scroll-to-top");
    if (scroll >= startPoint && $window_width >= 1024) {
        scrTopBtn.addClass('active');

    } else {
        scrTopBtn.removeClass('active');
    }
    scrTopBtn.on("click", function () {
        $("html, body").stop().animate({
                scrollTop: 0
            },
            600);
    });
};

/*
    site search
    ----------------------------------------------------
*/
function showing_search() {
    if ($window_width < 768) {
        jQuery($html_overlay).remove()
    }
    ;
    jQuery("body").removeClass("nt_second_menu_search_anims"),
        setTimeout(function () {
                jQuery("body").removeClass("nt_showing_search")
            },
            600)
};

function search_height() {
    var w_height = $(window).height();

    var $featured_cover_height = w_height * 0.67 * 0.80 - $searchDown_title_height,
        $featured_small_cover_height = $featured_cover_height / 2;
    $(".featured-search .item .content").css("height", $featured_cover_height),
        $(".featured-search .item-small .content").css("height", $featured_small_cover_height)
};

jQuery(document).ready(function ($) {
    $(window).resize(function () {
        search_height();
    });

});
jQuery(".btn-search").off("click").on("click",
    function () {
        if ($window_width < 768) {
            jQuery("body").append($html_overlay)
        }
        ;
        jQuery("body").addClass("nt_showing_search"),
            jQuery("body").addClass("nt_second_menu_search_anims"),
            jQuery(".top_searchform_wrapper input").focus(),
            search_height();

    }),

    document.addEventListener("keyup",
        function (t) {
            27 === t.keyCode && (jQuery("body").hasClass("nt_second_menu_search_anims") && showing_search())
        }),
    jQuery(".search_inner_close").on("click",
        function () {
            showing_search();
        });

/*
    post style03-04 cover height
    ----------------------------------------------------
*/
function postcoverHeight() {
    var $postcover_height = $window_height - $pageHeader_height;
    if ($("body").hasClass("post-style03") && $window_width < 768) {
        $('.post-cover').height($postcover_height);
    }
};

function toggleCommentAuthorInfo() {
    var changeMsg = "<i>[ 资料修改 ]</i>";
    var closeMsg = "<i>[ 收起来 ]</i>";
    $('.form-comment-info').slideToggle('slow', function () {
        if ($('.form-comment-info').css('display') == 'none') {
            $('#toggle-comment-author-info').html(changeMsg);
        } else {
            $('#toggle-comment-author-info').html(closeMsg);
        }
    });
};

jQuery(document).scroll(function ($) {
    // stickyHeader();
    scrollTop();
});


jQuery(document).ready(function ($) {

    variables();
    postcoverHeight();

    if (globals.home != 0) {
        $('.nt-slider').owlCarousel({
            items: 1,
            loop: true,
            nav: true,
            smartSpeed: 1200,
            autoplay: true,
            autoplayTimeout: 5000,
            autoplayHoverPause: true,
            navText: ['<i class="fa fa-angle-left"></i>', '<i class="fa fa-angle-right"></i>'],
            responsive: {
                0: {
                    nav: false,
                },
                992: {
                    nav: true,
                }
            }
        });
        $('.nt-featured-posts').owlCarousel({
            margin: 10,
            loop: true,
            nav: false,
            dots: false,
            responsiveClass: true,
            responsive: {
                0: {
                    items: 2,
                    center: false,
                    loop: false,
                    margin: 5,
                    nav: true,
                    navText: ['<i class="fa fa-angle-left"></i>', '<i class="fa fa-angle-right"></i>'],
                },
                480: {
                    items: 2,
                    center: false,
                    loop: false,
                    margin: 5,
                    nav: true,
                    navText: ['<i class="fa fa-angle-left"></i>', '<i class="fa fa-angle-right"></i>'],
                },
                768: {
                    items: 2,
                    center: false,
                    loop: false,
                    margin: 5,
                    nav: true,
                    navText: ['<i class="fa fa-angle-left"></i>', '<i class="fa fa-angle-right"></i>'],
                },
                992: {
                    items: 3,
                    center: false,
                    margin: 10,
                    loop: false

                },
                1170: {
                    items: 4,
                    margin: 20,
                    loop: false
                }

            }
        });

        $('.topic-grid').owlCarousel({
            loop: true,
            smartSpeed: 800,
            responsiveClass: true,
            responsive: {
                0: {
                    margin: 6,
                    items: 2,
                    dots: true,
                    nav: false
                },
                768: {
                    items: 1,
                    dots: true,
                    nav: false
                },
                1000: {
                    items: 1,
                    dots: true,
                    nav: true,
                    navText: ['<i class="fa fa-angle-left"></i>', '<i class="fa fa-angle-right"></i>']
                }
            }

        });


    }
    if (globals.single != 0 && globals.post_style == 'five') {
        var owl = $('.post-slide');
        owl.owlCarousel({
            items: 1,
            smartSpeed: 1050,
            loop: false,
            dots: true,
            nav: true,
            videoHeight: true,
            navText: ['<i class="fa fa-angle-left"></i>', '<i class="fa fa-angle-right"></i>']

        });
    }

    if (globals.single != 0 && globals.post_style == 'one' || globals.post_style == 'two' || globals.post_style == 'three' || globals.post_style == 'six') {

        /*
            Sticky Sidebar
            -------------------------------------------------------
        */
        $('.l-sidebar').theiaStickySidebar({
            additionalMarginTop: 90
        });
    }

    /*
        navbar-nav
        ----------------------------------------------------
    */
    $(".navbar-nav li:has(>ul)").addClass("has-children");

    if ($(".navbar-nav li").hasClass("has-children")) {
        $(".navbar-nav li.has-children").prepend('<span class="fa fa-angle-down"></span>')
    }

    $('#mobile-menu-icon').on('click touchstart', function (e) {
        e.preventDefault();
        var $navigation_height = $window_height - $searchHeader_height;
        $('.mobile-navigation').css({'height': $navigation_height});
        $('#mobile-overlay').addClass('open');
        $('body').addClass('mobile-open');

    });
    $('#mobile-close-icon').on('click touchstart', function (e) {
        e.preventDefault();
        $('#mobile-overlay').removeClass('open');
        $('body').removeClass('mobile-open');
        $('.mobile-navigation').css({'height': 'auto'});

    });

    /*
        mobile-bigger-cover
        ----------------------------------------------------
    */

    if ($window_width < 768) {

        $(".btn-open-share").on('click touchstart', function (e) {
            e.preventDefault();
            $('.bigger-share').addClass('open');
            $('.btn-open-share').hide();
            $('.btn-close').hide();
            $('.btn-close-share').show();
        });
        $(".btn-close-share").on('click touchstart', function (e) {
            e.preventDefault();
            $('.btn-close-share').hide();
            $('.bigger-share').removeClass('open');
            $('.bigger-share').addClass('close');
            $('.btn-open-share').show();
            $('.btn-close').show();
            setTimeout(function () {
                $('.bigger-share').removeClass('close');
            }, 200);

        });
    }
    /*
        mobile-navbar-Scrollbar
        ----------------------------------------------------
    */

    $(".mobile-navigation").mCustomScrollbar({
        theme: "minimal-dark",
        mouseWheel: {scrollAmount: 188, normalizeDelta: true}
    });

    /*
        Search Form Animation
        ----------------------------------------------------
    */


    $('#navbar-search-submit').click(function () {
        if (!$('body').hasClass('search-opened-removing')) {
            $('body').addClass('search-opened');
            $(this).parent().children('input').focus();
        }
    });
    $('.searchform.header-search').focusout(function () {
        $('body').removeClass('search-opened').addClass('search-opened-removing');
        setTimeout(function () {
            $('body').removeClass('search-opened-removing');
            $('#navbar-search-submit').removeClass('icon-close');

        }, 300);
    });


    /*
        comment
        ----------------------------------------------------
    */
    $(document).ready(function () {
        $('#comment').focus(function () {
            $('.form-captcha').fadeIn(300);
        });
        $('.form-comment-info').hide();
    });
    $(document).ready(function () {

        if ($('#author').val() == '') {
            $('.form-comment-info').show();
        } else {
            $('.form-comment-info').hide();
        }
    });

});

/*
-------------------------
LIKE
-------------------------
*/

var $ = jQuery.noConflict();

$.fn.postLike = function () {
    var objectId = $(this).data("id"),
        objectType = $(this).data('type'),
        action = $(this).data('action'),
        rateHolder = $(this).children('.count');
        holder = $(this);
    var ajax_data = {
        objectId: objectId,
        objectType: objectType
    };
    var url = globals.ajax_url+'/'+action;
    $.post(url, ajax_data,
        function (data) {
            if (data.code === '1') {
                mi_prompt('error', '发生未知错误');
            } else {
                if (action === 'like') {
                    $(rateHolder).html($(rateHolder).text() * 1 + 1);
                    $(holder).data('action', 'cancelLike');
                    $(holder).children('.iconfont').removeClass('icon-like1');
                    $(holder).children('.iconfont').addClass('icon-like');
                } else {
                    $(rateHolder).html($(rateHolder).text() * 1 - 1);
                    $(holder).data('action', 'like');
                    $(holder).children('.iconfont').removeClass('icon-like');
                    $(holder).children('.iconfont').addClass('icon-like1');
                }
            }
        });
    return false;
};

$.fn.postFavorite = function () {
    var objectId = $(this).data("id"),
        objectType = $(this).data('type'),
        action = $(this).data('action'),
        rateHolder = $(this).children('.count');
    holder = $(this);
    var ajax_data = {
        objectId: objectId,
        objectType: objectType
    };
    var url = globals.ajax_url+'/'+action;
    $.post(url, ajax_data,
        function (data) {
            if (data.code === '1') {
                mi_prompt('error', '发生未知错误');
            } else {
                if (action ==='favorite') {
                    $(rateHolder).html($(rateHolder).text() * 1 + 1);
                    $(holder).data('action', 'cancelFavorite');
                    $(holder).children('.iconfont').removeClass('icon-favorites-o');
                    $(holder).children('.iconfont').addClass('icon-favoritesfilling');
                } else if (action === 'cancelFavorite') {
                    $(rateHolder).html($(rateHolder).text() * 1 - 1);
                    $(holder).data('action', 'favorite');
                    $(holder).children('.iconfont').removeClass('icon-favoritesfilling');
                    $(holder).children('.iconfont').addClass('icon-favorites-o');
                }
            }
        });
    return false;
};

$(document).on("click", "#like", function () {
    $(this).postLike();
});

$(document).on("click", "#favorite", function () {
    $(this).postFavorite();
});

function timestamp2date(timestamp) {
    return new Date(timestamp*1000).toLocaleDateString();
};

$(document).ready(function () {
    $(".timestamp").each(function() {
        var timestamp = $(this).text();
        var dt = timestamp2date(timestamp);
        $(this).text(dt)
    });
});

function randomColor(color) {
    var red = parseInt(Math.random()*128).toString(16);
    var blue = parseInt(Math.random()*128).toString(16);
    var green= parseInt(Math.random()*128).toString(16);

    var color = '#'+red+blue+green;
    return color
};

$(document).ready(function () {
    $(".question-color").each(function() {
        var color = randomColor();
        $(this).css('background', color);
    });
});


$(document).on("click", "#ShowRecommend", function () {
    // $(this).showRecommend();
    // mi_prompt('error', '发生未知错误');
    if ($('#recommend-content').css('display') == 'none') {
        $('#recommend-content').css('display', 'block');
        $(this).children('i').removeClass('icon-arrow-down-circle');
        $(this).children('i').addClass('icon-arrow-up-circle');
    } else {
        $('#recommend-content').css('display', 'none');
        $(this).children('i').removeClass('icon-arrow-up-circle');
        $(this).children('i').addClass('icon-arrow-down-circle');
    }
});


(function ($) {
    $.fn.miPopup = function () {

        this.bind('click touchstart', function (event) {
            // event.preventDefault();

            var html = $('<div class="dialog_overlay"></div>');

            var selector = $(this).data('selector');

            var close_icon = $(selector).find('.btn-close');

            $(selector).addClass('open').find('.btn-close').on('click touchstart', function (event) {
                event.preventDefault();
                $(html).remove();
                $(selector).removeClass('open');
                $(selector).addClass('close');
                $('body').removeClass('modal-open');
                setTimeout(function () {
                    $(selector).removeClass('close');
                }, 200);
                close_icon.unbind();
            });
            $('body').addClass('modal-open');
            $('body').append(html);

            $('body').on("keyup", function (e) {
                if (e.keyCode === 27) close_icon.click();
            });

        });

    };
    $('[data-module="miPopup"]').miPopup();
})(jQuery);

function isElementInViewport(el) {
    var rect = el.getBoundingClientRect();
    return (
        rect.top >= 0 &&
        rect.left >= 0 &&
        rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) &&
        rect.right <= (window.innerWidth || document.documentElement.clientWidth)
    );
}

function givenElementInViewport(el, fn) {
    return function () {
        if (isElementInViewport(el)) {
            fn.call();
        }
    }
}

function addViewportEvent(el, fn) {
    if (window.addEventListener) {
        addEventListener('DOMContentLoaded', givenElementInViewport(el, fn), false);
        addEventListener('load', givenElementInViewport(el, fn), false);
        addEventListener('scroll', givenElementInViewport(el, fn), false);
        addEventListener('resize', givenElementInViewport(el, fn), false);
    } else if (window.attachEvent) {
        attachEvent('DOMContentLoaded', givenElementInViewport(el, fn));
        attachEvent('load', givenElementInViewport(el, fn));
        attachEvent('scroll', givenElementInViewport(el, fn));
        attachEvent('resize', givenElementInViewport(el, fn));
    }
}

if ($('.m-ajax-load').length > 0) {
    addViewportEvent(document.querySelector('.m-ajax-load'), function () {
        if ($('.dm-ajax-load').data('comments') == 'comments') {
            return false;
        }
        if ($('.dm-ajax-load').hasClass('loading') === false) {
            if ($('.dm-ajax-load').data('paged') <= 10) {
                $('.dm-ajax-load').addClass('loading');
                ajax_load_posts($('.dm-ajax-load').data());
            }
        }
    });
}

$(document).on('click', '.dm-ajax-load', function (event) {
    event.preventDefault();
    if ($('.dm-ajax-load').hasClass('loading') === false) {

        $('.dm-ajax-load').addClass('loading');
        ajax_load_posts($('.dm-ajax-load').data());
    }
});

function ajax_load_posts(data) {
    $('.post-loading').show();
    $('.dm-ajax-load').hide();
    console.log(data);

    var action = data.action,
        url = globals.ajax_url + '/' + action;
    // alert(url);
    $.ajax({
        url: url,
        type: 'POST',
        dataType: 'html',
        data: data,
    })
        .done(function (response) {
            // alert("data.action", data.action)
            // alert("response", response)
            if (response) {
                // alert(data.action.indexOf('activity') >=0)
                if (data.action === 'comment') {
                    $('.' + data.append).append(response);
                    $('.dm-ajax-load').data('paged', $(".comment:last").attr("id").split("-")[1]);
                    if ($("#comment-number").text() == $(".comment").size()) {
                        $('.dm-ajax-load').text('没有了').show();
                    } else {
                        $('.dm-ajax-load').removeClass('loading').show();
                    }
                } else {
                    $('.' + data.append).append(response);
                    if (data.action.indexOf('favorite') >= 0
                        || data.action.indexOf('activity') >= 0
                        || data.action.indexOf('following') >= 0){
                        $('.dm-ajax-load').data('start', $(".item:last").data("last"));
                    }
                    $('.dm-ajax-load').data('paged', data.paged * 1 + 1);
                    $('.topic-grid').owlCarousel({
                        loop: true,
                        smartSpeed: 800,
                        responsiveClass: true,
                        responsive: {
                            0: {
                                margin: 5,
                                items: 2,
                                dots: true,
                                nav: false
                            },
                            768: {
                                items: 1,
                                dots: true,
                                nav: false
                            },
                            1000: {
                                items: 1,
                                dots: true,
                                nav: true,
                                navText: ['<i class="fa fa-angle-left"></i>', '<i class="fa fa-angle-right"></i>']
                            }
                        }
                    });

                    $('.dm-ajax-load').removeClass('loading').show();
                }
            } else {
                $('.dm-ajax-load').text('没有了').show();
            }

        })
        .fail(function () {
            console.log("error");
            $('.post-loading').hide();
        })
        .always(function () {
            $('.post-loading').hide();
        });
}

$(document).on('click', '.comment-action', function (event) {
    event.preventDefault();

    var t = $(this),
        data = t.data(),
        action = $(this).data('action');

    $.ajax({
        url: globals.ajax_url,
        type: 'POST',
        dataType: 'json',
        data: data
    })
        .done(function (data) {
            if (data == '1') {
                if (action == 'like') {
                    t.children('.count').text(t.children('.count').text() * 1 + 1);
                    t.data('action', 'cancel_like');
                    t.children('.iconfont').removeClass('icon-like1');
                    t.children('.iconfont').addClass('icon-like');
                } else {
                    t.children('.count').text(t.children('.count').text() * 1 - 1);
                    t.data('action', 'like');
                    t.children('.iconfont').removeClass('icon-like');
                    t.children('.iconfont').addClass('icon-like1');
                }
            } else {
                mi_prompt('error', '发生未知错误');
            }
        });


});

$(document).on('click', '.captcha-image img', function (event) {
    event.preventDefault();
    var src = $(this).attr('src');

    if (src.indexOf('&') > 0) {
        var new_src = src.substring(0, src.indexOf('&')) + '&time=' + Date.parse(new Date());
    } else {
        var new_src = src + '&time=' + Date.parse(new Date());
    }

    $(this).attr('src', new_src);

});

function mi_prompt(type, msg) {

    if (type == 'error') {
        var html = '<div id="sometips" class="sitetips tips-error tips-open">';
    } else {
        var html = '<div id="sometips" class="sitetips tips-success tips-open">';
    }
    html += '<div class="tips_overlay"></div>';
    html += '<div class="tips_content">';
    if (type == 'error') {
        html += '<i class="icon icon-exclamation"></i>';
    } else {
        html += '<i class="icon icon-check"></i>';
    }
    html += '<p>' + msg + '</p>';
    html += '</div>';
    html += '</div> ';

    $('body').append(html);
    setTimeout(function () {
        $('#sometips').removeClass('tips-open');
        $('#sometips').addClass('tips-close');
        setTimeout("$('#sometips').remove()", 800);
    }, 1500);

}

$(document).on('click', '#sometips', function (event) {
    event.preventDefault();
    $('#sometips').removeClass('tips-open');
    $('#sometips').addClass('tips-close');
    setTimeout(function () {
        $('#sometips').remove();
    }, 200);
});

function popupImage() {
    $('.suxing-popup-image').magnificPopup({
        type: 'image',
        closeOnContentClick: true,
        closeMarkup: '<button title="%title%" type="button" class="mfp-close suxing-mfp-close-button"></button>',
        fixedContentPos: true,
        fixedBgPos: true,
        overflowY: 'auto',
        removalDelay: 300,
        image: {
            titleSrc: function (item) {
                return item.el.find('img').attr('alt');
                //return  item.el.find('img').attr('alt') + item.el.attr('title');
            }
        },
        mainClass: 'suxing-popup-slide-in',
        callbacks: {
            beforeOpen: function () {
                this.container.data('scrollTop', parseInt($(window).scrollTop()));
            },
            afterClose: function () {
                $('html, body').scrollTop(this.container.data('scrollTop'));
            },
        }
    });
}

function popupGallery(gclass, aclass) {
    var gclass = gclass ? gclass : '.suxing-popup-gallery',
        aclass = aclass ? aclass : 'a.suxing-popup-gallery-item';
    $(gclass).each(function () {
        $(this).magnificPopup({
            delegate: aclass,
            type: 'image',
            gallery: {
                enabled: true,
                navigateByImgClick: true,
                arrowMarkup: '<button title="%title%" type="button" class="suxing-mfp-arrow suxing-mfp-arrow-%dir%"></button>',
                tPrev: 'Previous',
                tNext: 'Next',
                tCounter: '<span>%curr% / %total%</span>'
            },
            image: {
                titleSrc: function (item) {
                    return item.el.find('img').attr('alt');
                    //return  item.el.find('img').attr('alt') + item.el.attr('title');
                }
            },
            closeMarkup: '<button title="%title%" type="button" class="mfp-close suxing-mfp-close-button"></button>',
            fixedContentPos: true,
            fixedBgPos: true,
            overflowY: 'auto',
            removalDelay: 300,
            mainClass: 'suxing-popup-slide-in',
            callbacks: {
                beforeOpen: function () {
                    this.container.data('scrollTop', parseInt($(window).scrollTop()));
                },
                afterClose: function () {
                    $('html, body').scrollTop(this.container.data('scrollTop'));
                },
            }
        });
    });
}

jQuery(document).ready(function ($) {

    if (globals.image_popup !== 'null' && globals.image_popup !== 'disable') {

        if (globals.image_popup == 'image') {
            var aclass = 'suxing-popup-image';
        } else if (globals.image_popup == 'gallery') {
            var aclass = 'suxing-popup-gallery-item';
        }
        var matching = new RegExp("\[.](?:gif|png|jpg|jpeg|webp)($|[?])"),
            image_popup;
        $(".suxing-popup-gallery a").each(function () {

            if (matching.test($(this).attr('href')) && $(this).children('img').length == 1) {
                $(this).addClass(aclass);
                image_popup = true;
            } else {
                image_popup = false;
            }

        });

        if (image_popup) {
            if (globals.image_popup == 'image') {
                popupImage();
            } else if (globals.image_popup == 'gallery') {
                popupGallery();
            }
            //popupIframe();
        }

    }

    if ($('.suxing-post-popup-gallery').length > 0) {
        popupGallery('.suxing-post-popup-gallery', 'a.suxing-post-popup-gallery-item');
    }

});

$(document).on('click', '.comment-reply-link', function (event) {
    event.preventDefault();
});

$(document).on('click', '.add_image', function (event) {
    event.preventDefault();
    $('#comment').insertAtCaret(" [img src='图片地址' alt='图片描述'] ");
});

$(document).on('click', '.add_code', function (event) {
    event.preventDefault();
    $('#comment').insertAtCaret("[code]\nCode\n[/code]");
});

$(mi_comment_hide());

function mi_comment_hide() {
    $.each($('.children'), function (index, val) {
        var li_count = $(this).children('li').length,
            show_count = li_count - 2;

        if (li_count > 2 && $(this).children('.load-more-comment').length < 1) {
            $(this).children('li').each(function (index, el) {
                if (index == 1) {
                    $(this).after('<span data-count="' + show_count + '" class="load-more-comment o"><button class="btn">还有' + show_count + '条回复 <i class="fa fa-angle-down" aria-hidden="true"></i></button></span>');
                }
            });
        }
    });

    $('.load-more-comment').nextAll().hide();
}

$(document).on('click', '.load-more-comment', function (event) {
    t = $(this);
    t.nextAll().slideToggle('400');
    if (t.hasClass('o')) {
        t.removeClass('o').addClass('c');
        t.children('.btn').html('收起 <i class="fa fa-angle-up" aria-hidden="true"></i>');
    } else {
        t.removeClass('c').addClass('o');
        t.children('.btn').html('还有' + t.data('count') + '条回复 <i class="fa fa-angle-down" aria-hidden="true"></i>');
    }
});

$(document).on('click', '.filter-menu button', function (event) {
    event.preventDefault();
    var t = $(this);
    if (!t.hasClass('active')) {
        $('.filter-menu button').removeClass('active');
        t.addClass('active');

        var cid = t.data('cid');
        if (cid) {
            $('.dm-ajax-load').data('tabcid', cid);
        } else {
            $('.dm-ajax-load').removeData('tabcid');
        }
        $('.dm-ajax-load').data('paged', 1);
        $('.home-list').html('');
        $('.dm-ajax-load').addClass('loading').text('加载更多');
        ajax_load_posts($('.dm-ajax-load').data());
    }


});

$(document).on('click touchstart', '.btn-bigger-cover', function (event) {
    event.preventDefault();
    var bigger_cover = $('#bigger-cover img');

    if (bigger_cover.hasClass('load_bigger_img')) {

        $.ajax({
            url: globals.ajax_url,
            type: 'POST',
            dataType: 'json',
            data: bigger_cover.data(),
        })
            .done(function (data) {
                if (data.s == 200) {
                    bigger_cover.attr('src', data.src);
                    $('.bigger_share').attr('href', data.share);
                    $('.bigger_down').attr('href', data.src);
                    bigger_cover.removeClass('load_bigger_img');
                    $('.image-loading').remove();
                } else {
                    mi_prompt('error', data.m);
                }
            })
            .fail(function () {
                mi_prompt('error', '网络错误，请稍后再试！');
            });


    }

});


$(document).on("input propertychange", "#qqnum", function (event) {
    event.preventDefault();
    var tval = $(this).val();
    var mt = window.setTimeout(function () {
        var nval = $("#qqnum").val();
        if (nval.length > 0 && tval == $("#qqnum").val()) {

            $.ajax({
                url: 'http://r.pengyou.com/fcg-bin/cgi_get_portrait.fcg?uins=' + nval,
                dataType: 'jsonp',
                jsonpCallback: 'portraitCallBack',
                scriptCharset: "GBK",
                contentType: "text/html; charset=GBK",
                success: function (data) {
                    $('#author').val(data[nval][6]);
                    $('#email').val(nval + '@qq.com');
                }
            })
        }
    }, 400);
});

$(document).on('change', '#switchy', function (event) {
    event.preventDefault();
    if ($(this).is(':checked')) {

        $.ajax({
            url: globals.ajax_url,
            type: 'POST',
            dataType: 'json',
            data: {action: 'slide-veri', code: $('#slidecode').val()},
        })
            .done(function (data) {
                if (data.s == 200) {
                    $('#submit').removeAttr('disabled');
                    $('#switchy').attr('disabled', 'disabled');
                }
            });

    }
});
