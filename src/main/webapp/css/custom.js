(function(a){var b=0;var c={initialised:false,version:1,mobile:false,init:function(){if(!this.initialised){this.initialised=true}else{return}this.RTL();this.Menu();this.HeaderSlider();this.BannerSlider();this.WorldNews_Slider();this.Sport_Slider();this.Food_Health();this.Travel_Slider();this.TechnologySlider();this.MoreOption_Sidebar();this.Magnific_Popup();this.UserProfile();this.Search_Popup();this.RightToggle();this.NavToggleOpen();this.BannerLeftSlider();this.BannerRightSlider();this.BannerCenterSlider();this.SortToggle();this.Fullwidth_Multislide_Slider();this.InstargamSlider();this.CookiesPopup();this.SinglepageToggle();this.CommentAction();this.CustomTab();this.TestimonialSlider();this.ContactFormSubmit();this.StickySidebar();this.wow()},RTL:function(){var d=a("html").attr("dir");if(d){a("html").find("body").addClass("rtl")}},Menu:function(){var d=window.innerWidth;if(d<991){a(".blog_menu_toggle").on("click",function(f){if(a(".blog_main_menu_innerdiv li.dd_open").length){a(".blog_main_menu_innerdiv li.dd_open .sub-menu").hide();a(".blog_main_menu_innerdiv li.dd_open").removeClass("dd_open")}a(".blog_main_menu ").slideToggle("slow")});a(document).on("click",".blog_main_menu_innerdiv ul li.blog_dropdown",function(f){a(".blog_main_menu_innerdiv ul li.dd_open").not(a(this)).removeClass("dd_open").find("ul.sub-menu").slideUp();a(this).addClass("dd_open").find(".sub-menu").slideToggle()})}a(".blog_main_menu_innerdiv ul li ul.sub-menu").parent("li").addClass("blog_dropdown")},HeaderSlider:function(){var d=new Swiper(".blog_tranding_slider .swiper-container",{direction:"vertical",loop:true,speed:1500,autoplay:true,navigation:{nextEl:".swiper-button-next",prevEl:".swiper-button-prev",}})},BannerSlider:function(){var d=new Swiper(".gallery-thumbs",{spaceBetween:20,direction:"vertical",slidesPerView:"auto",loop:false,touchRatio:1,freeMode:true,loopedSlides:3,watchSlidesVisibility:true,watchSlidesProgress:true,breakpoints:{1800:{direction:"vertical",},1400:{direction:"vertical",},992:{direction:"vertical",},767:{direction:"horizontal",touchRatio:0.2,},640:{direction:"horizontal",touchRatio:0.2,},480:{direction:"horizontal",touchRatio:0.2,},375:{direction:"horizontal",touchRatio:0.2,}},});var e=new Swiper(".gallery-top",{spaceBetween:0,loop:false,touchRatio:0,effect:"fade",loopedSlides:3,navigation:{nextEl:".swiper-button-next",prevEl:".swiper-button-prev",},thumbs:{swiper:d,},breakpoints:{767:{direction:"horizontal",touchRatio:0.2,},640:{direction:"horizontal",touchRatio:0.2,},480:{direction:"horizontal",touchRatio:0.2,},375:{direction:"horizontal",touchRatio:0.2,}},})},WorldNews_Slider:function(){new Swiper(".blog_world_news_slider .swiper-container",{loop:false,loopedSlides:1,slidesPerView:1,slidesPerColumn:2,spaceBetween:0,navigation:{nextEl:".worldnews-swiper-button-next",prevEl:".worldnews-swiper-button-prev",},breakpoints:{767:{slidesPerColumn:2,},480:{slidesPerColumn:1,},},});a(".worldnews_tab .tab-pane").css("display","none");a("#nav-tab a").on("click",function(d){var f=a(this).attr("href");a(".worldnews_tab .tab-pane").hide();a(f).show()});a(".worldnews_tab .tab-pane.active.show").show();a(".worldnews_tab2 .tab-pane").css("display","none");a("#nav-tab a").on("click",function(d){a(".worldnews_tab2  .custom_tab_content .tab").css("display","none");var f=a(this).attr("href");a(".worldnews_tab2 .tab-pane").hide();a(f).show()});a(".worldnews_tab2 .tab-pane.active.show").show();a(".worldnews_tab2 .tabs.animated-fade .tab-links .link_data a").on("click",function(d){a(".worldnews_tab2 .tab-content .tab-pane").css("display","none")})},CustomTab:function(){a(".custom_tab_content .tab").hide();a(".tabs.animated-fade .tab-links .link_data a").on("click",function(f){var d=a(this).attr("href");a(".custom_tab_content "+d).show().addClass("show").siblings().hide().removeClass("show");a(this).parent("li").addClass("active").siblings().removeClass("active");f.preventDefault()})},Sport_Slider:function(){new Swiper(".blog_sport_slider .swiper-container",{slidesPerView:2,slidesPerColumn:3,spaceBetween:20,navigation:{nextEl:".sport-swiper-button-next",prevEl:".sport-swiper-button-prev",},breakpoints:{1024:{slidesPerColumn:3,slidesPerView:2,},767:{slidesPerColumn:1,slidesPerView:1,},320:{slidesPerColumn:1,slidesPerView:1,},},});a(".blog_sports .tab-pane").css("display","none");a("#nav-tab1 a").on("click",function(d){a(".blog_sports .custom_tab_content .tab").css("display","none");var f=a(this).attr("href");a(".blog_sports .tab-pane").hide();a(f).show()});a(".blog_sports .tab-pane.active.show").show();a(".blog_sports .tabs.animated-fade .tab-links .link_data a").on("click",function(d){a(".blog_sports .tab-content .tab-pane").css("display","none")})},Food_Health:function(){var d=new Swiper(".thumbs1",{spaceBetween:20,direction:"vertical",slidesPerView:"auto",loop:false,touchRatio:0.1,freeMode:true,loopedSlides:5,watchSlidesVisibility:true,watchSlidesProgress:true,breakpoints:{1800:{direction:"vertical",},1400:{direction:"vertical",},992:{direction:"vertical",},767:{direction:"horizontal",touchRatio:0.2,},640:{direction:"horizontal",touchRatio:0.2,},480:{direction:"horizontal",touchRatio:0.2,},375:{direction:"horizontal",touchRatio:0.2,}},});var e=new Swiper(".gallery1",{spaceBetween:0,loop:false,touchRatio:0,effect:"fade",loopedSlides:3,navigation:{nextEl:".tab-next-1",prevEl:".tab-prev-1",},thumbs:{swiper:d,},breakpoints:{767:{direction:"horizontal",touchRatio:0.2,},640:{direction:"horizontal",touchRatio:0.2,},480:{direction:"horizontal",touchRatio:0.2,},375:{direction:"horizontal",touchRatio:0.2,}},});var d=new Swiper(".thumbs2",{spaceBetween:20,direction:"vertical",slidesPerView:"auto",loop:false,touchRatio:0.1,freeMode:true,loopedSlides:5,watchSlidesVisibility:true,watchSlidesProgress:true,breakpoints:{1800:{direction:"vertical",},1400:{direction:"vertical",},992:{direction:"vertical",},767:{direction:"horizontal",touchRatio:0.2,},640:{direction:"horizontal",touchRatio:0.2,},480:{direction:"horizontal",touchRatio:0.2,},375:{direction:"horizontal",touchRatio:0.2,}},});var e=new Swiper(".gallery2",{spaceBetween:0,loop:false,touchRatio:0,effect:"fade",loopedSlides:3,navigation:{nextEl:".tab-next-2",prevEl:".tab-prev-2",},thumbs:{swiper:d,},breakpoints:{767:{direction:"horizontal",touchRatio:0.2,},640:{direction:"horizontal",touchRatio:0.2,},480:{direction:"horizontal",touchRatio:0.2,},375:{direction:"horizontal",touchRatio:0.2,}},});var d=new Swiper(".thumbs3",{spaceBetween:20,direction:"vertical",slidesPerView:"auto",loop:false,touchRatio:0.1,freeMode:true,loopedSlides:5,watchSlidesVisibility:true,watchSlidesProgress:true,breakpoints:{1800:{direction:"vertical",},1400:{direction:"vertical",},992:{direction:"vertical",},767:{direction:"horizontal",touchRatio:0.2,},640:{direction:"horizontal",touchRatio:0.2,},480:{direction:"horizontal",touchRatio:0.2,},375:{direction:"horizontal",touchRatio:0.2,}},});var e=new Swiper(".gallery3",{spaceBetween:0,loop:false,touchRatio:0,effect:"fade",loopedSlides:3,navigation:{nextEl:".tab-next-3",prevEl:".tab-prev-3",},thumbs:{swiper:d,},breakpoints:{767:{direction:"horizontal",touchRatio:0.2,},640:{direction:"horizontal",touchRatio:0.2,},480:{direction:"horizontal",touchRatio:0.2,},375:{direction:"horizontal",touchRatio:0.2,}},});var d=new Swiper(".thumbs4",{spaceBetween:20,direction:"vertical",slidesPerView:"auto",loop:false,touchRatio:0.1,freeMode:true,loopedSlides:5,watchSlidesVisibility:true,watchSlidesProgress:true,breakpoints:{1800:{direction:"vertical",},1400:{direction:"vertical",},992:{direction:"vertical",},767:{direction:"horizontal",touchRatio:0.2,},640:{direction:"horizontal",touchRatio:0.2,},480:{direction:"horizontal",touchRatio:0.2,},375:{direction:"horizontal",touchRatio:0.2,}},});var e=new Swiper(".gallery4",{spaceBetween:0,loop:false,touchRatio:0,effect:"fade",loopedSlides:3,navigation:{nextEl:".tab-next-4",prevEl:".tab-prev-4",},thumbs:{swiper:d,},breakpoints:{767:{direction:"horizontal",touchRatio:0.2,},640:{direction:"horizontal",touchRatio:0.2,},480:{direction:"horizontal",touchRatio:0.2,},375:{direction:"horizontal",touchRatio:0.2,}},});var d=new Swiper(".thumbs5",{spaceBetween:20,direction:"vertical",slidesPerView:"auto",loop:false,touchRatio:0.1,freeMode:true,loopedSlides:5,watchSlidesVisibility:true,watchSlidesProgress:true,breakpoints:{1800:{direction:"vertical",},1400:{direction:"vertical",},992:{direction:"vertical",},767:{direction:"horizontal",touchRatio:0.2,},640:{direction:"horizontal",touchRatio:0.2,},480:{direction:"horizontal",touchRatio:0.2,},375:{direction:"horizontal",touchRatio:0.2,}},});var e=new Swiper(".gallery5",{spaceBetween:0,loop:false,touchRatio:0,effect:"fade",loopedSlides:3,navigation:{nextEl:".tab-next-5",prevEl:".tab-prev-5",},thumbs:{swiper:d,},breakpoints:{767:{direction:"horizontal",touchRatio:0.2,},640:{direction:"horizontal",touchRatio:0.2,},480:{direction:"horizontal",touchRatio:0.2,},375:{direction:"horizontal",touchRatio:0.2,}},});a(".blog_food_health .tab-pane").css("display","none");a("#nav-tab2 a").on("click",function(f){a(".blog_food_health .custom_tab_content .tab").css("display","none");var g=a(this).attr("href");a(".blog_food_health .tab-pane").hide();a(g).show()});a(".blog_food_health .tab-pane.active.show").show();a(".blog_food_health .tabs.animated-fade .tab-links .link_data a").on("click",function(f){a(".blog_food_health .tab-content .tab-pane").css("display","none")})},Travel_Slider:function(){new Swiper(".blog_travel_slider .swiper-container",{loop:false,loopedSlides:1,slidesPerView:1,slidesPerColumn:2,spaceBetween:0,navigation:{nextEl:".travel-swiper-button-next",prevEl:".travel-swiper-button-prev",},breakpoints:{767:{slidesPerColumn:2,},},});a(".blog_travel .tab-pane").css("display","none");a("#nav-tab3 a").on("click",function(d){a(".blog_travel .custom_tab_content .tab").css("display","none");var f=a(this).attr("href");a(".blog_travel .tab-pane").hide();a(f).show()});a(".blog_travel .tab-pane.active.show").show();a(".blog_travel .tabs.animated-fade .tab-links .link_data a").on("click",function(d){a(".blog_travel .tab-content .tab-pane").css("display","none")})},TechnologySlider:function(){new Swiper(".blog_technology_slider .swiper-container",{loop:false,loopedSlides:1,slidesPerView:1,slidesPerColumn:4,spaceBetween:0,navigation:{nextEl:".technology-swiper-button-next",prevEl:".technology-swiper-button-prev",},breakpoints:{767:{slidesPerView:1,slidesPerColumn:1,},},});a(".blog_technology .tab-pane").css("display","none");a("#nav-tab4 a").on("click",function(d){a(".blog_technology .custom_tab_content .tab").css("display","none");var f=a(this).attr("href");a(".blog_technology .tab-pane").hide();a(f).show()});a(".blog_technology .tab-pane.active.show").show();a(".blog_technology .tabs.animated-fade .tab-links .link_data a").on("click",function(d){a(".blog_technology .tab-content .tab-pane").css("display","none")})},MoreOption_Sidebar:function(){a(".blog_news_action").on("click",function(d){a("ul.more_option").not(a(this).closest(".blog_news").find("ul.more_option")).removeClass("open_option");a(this).closest(".blog_news").find("ul.more_option").toggleClass("open_option")});a(document).on("click",function(d){if(!a(d.target).closest(".blog_news_action").length){a("ul.more_option").removeClass("open_option")}})},Magnific_Popup:function(){a(".widget_instagram_news ul li").magnificPopup({delegate:"a.blog_popup",type:"image",mainClass:"mfp-with-zoom",gallery:{enabled:true,},})},UserProfile:function(){a(document).on("click",".blog_user_div a",function(){a(this).closest(".blog_user_div").toggleClass("profile_open")});a(".blog_user_div").html('<div class="blogUserWrapper">'+a(".blog_user_div").html()+"</div>");a(document).on("click",function(d){if(!a(d.target).closest(".blogUserWrapper").length){a(".blog_user_div").removeClass("profile_open")}})},Search_Popup:function(){a(".blog_search > a").on("click",function(){a(this).parent().addClass("show_search")});a(".search_close").on("click",function(){a(".search_close").closest(".blog_search ").removeClass("show_search")})},RightToggle:function(){a(".blog_righttoggle a").on("click",function(){a("body").addClass("right_toggle_open")});a(".toggle_close").on("click",function(){a("body").removeClass("right_toggle_open")});a(".outer_close").on("click",function(){a("body").removeClass("right_toggle_open")})},NavToggleOpen:function(){a(".tab_toggle_menu a").on("click",function(){a(".nav-tabs").not(a(this).closest(".blog_topheading_slider_nav").find(".nav-tabs")).removeClass("nav_toggle_open");a(this).closest(".blog_topheading_slider_nav").find(".nav-tabs").toggleClass("nav_toggle_open")})},BannerLeftSlider:function(){new Swiper(".blog_banner_slider_left_vertical .swiper-container",{spaceBetween:0,direction:"vertical",slidesPerView:3,loop:true,autoplay:{delay:2000},touchRatio:0.1,freeMode:true,loopedSlides:3,watchSlidesVisibility:true,watchSlidesProgress:true,})},BannerRightSlider:function(){new Swiper(".blog_banner_slider_right_vertical .swiper-container",{spaceBetween:0,direction:"vertical",slidesPerView:3,loop:true,autoplay:{delay:2000,reverseDirection:true,},touchRatio:0.1,freeMode:true,loopedSlides:3,watchSlidesVisibility:true,watchSlidesProgress:true,})},BannerCenterSlider:function(){var d=new Swiper(".blog_banner_slider_center .swiper-container",{spaceBetween:0,loop:false,touchRatio:0,navigation:{nextEl:".swiper-button-next",prevEl:".swiper-button-prev",},})},SortToggle:function(){a(".blog_sorting_togglediv span").on("click",function(d){a(".sort_toggleclose").closest(".blog_sorting_option").slideUp(200);d.preventDefault();a(this).parent().find(".blog_sorting_option").slideDown(200)});a(".sort_toggleclose").on("click",function(d){d.preventDefault();a(this).closest(".blog_sorting_option").slideUp(200)});a(document).on("click",function(d){if(!a(d.target).closest(".blog_sorting_togglediv").length){a(".sort_toggleclose").closest(".blog_sorting_option").slideUp(200)}})},Fullwidth_Multislide_Slider:function(){var d=new Swiper(".blog_fullwidth_multislide_slider .swiper-container",{slidesPerView:6,spaceBetween:20,loop:true,autoplay:{delay:2000},touchRatio:0.1,freeMode:true,loopedSlides:6,breakpoints:{480:{slidesPerView:1,},600:{slidesPerView:2,},767:{slidesPerView:3,},992:{slidesPerView:3,},1200:{slidesPerView:5,},1530:{slidesPerView:5,}},})},InstargamSlider:function(){var d=new Swiper(".blog_instagram_slider .swiper-container",{slidesPerView:6,spaceBetween:20,loop:true,autoplay:{delay:2000},touchRatio:0.1,freeMode:true,loopedSlides:6,breakpoints:{480:{slidesPerView:1,},600:{slidesPerView:2,},767:{slidesPerView:3,},992:{slidesPerView:3,},1200:{slidesPerView:5,},1530:{slidesPerView:5,}},})},CookiesPopup:function(){a(".blog_icon").on("click",function(d){d.preventDefault();a(this).parent().toggleClass("open animation_effect")});a(".cookie_btn").on("click",function(d){d.preventDefault();a(".blog_cookies_div").hide();b=1})},SinglepageToggle:function(){a(".blog_toggleonclick").on("click",function(d){d.preventDefault();a(".blog_toggleonclick").not(a(this).closest(".blog_comment_meta").find(".blog_toggleonclick")).removeClass("menu_open");a(this).closest(".blog_comment_meta").find(".blog_toggleonclick").toggleClass("menu_open")});a(document).on("click",function(d){if(!a(d.target).closest(".blog_toggleonclick").length){a(".blog_toggleonclick").removeClass("menu_open")}})},CommentAction:function(){a(".blog_comment_action").on("click",function(d){a("ul.comment_action").not(a(this).closest(".blog_comment_meta").find("ul.comment_action")).removeClass("open");a(this).closest(".blog_comment_meta").find("ul.comment_action").toggleClass("open")});a(document).on("click",function(d){if(!a(d.target).closest(".blog_comment_action").length){a(".comment_action").removeClass("open")}})},TestimonialSlider:function(){var d=new Swiper(".blog_testimonial_slider .testimonial-thumbs",{spaceBetween:0,slidesPerView:3,initialSlide:1,loop:false,loopedSlides:3,freeMode:true,direction:"horizontal",watchSlidesVisibility:true,watchSlidesProgress:true,});var e=new Swiper(".blog_testimonial_slider .testimonial-top",{spaceBetween:30,direction:"horizontal",thumbs:{swiper:d}})},ContactFormSubmit:function(){if(a("#send_btn").length>0){a("#send_btn").on("click",function(){var d=a("#ur_name").val();var i=a("#ur_mail").val();var f=a("#ur_phone").val();var h=a("#sub").val();var g=a("#msg").val();a.ajax({type:"POST",url:"ajaxmail.php",data:{username:d,useremail:i,userphone:f,usersub:h,mesg:g},success:function(j){var e=j.split("#");if(e[0]=="1"){a("#ur_name").val("");a("#ur_mail").val("");a("#ur_phone").val("");a("#sub").val("");a("#msg").val("");a("#err").html(e[1])}else{a("#ur_name").val(d);a("#ur_mail").val(i);a("#ur_phone").val(f);a("#sub").val(h);a("#msg").val(g);a("#err").html(e[1])}}})})}},StickySidebar:function(){a(".theiaStickySidebar").theiaStickySidebar({additionalMarginTop:30,additionalMarginBottom:30,})},wow:function(){new WOW().init()}};a(document).ready(function(){c.init()});jQuery(window).on("load",function(){jQuery("#blog_preloader_box").fadeOut();jQuery("#blog_preloader_wrapper").delay(350).fadeOut("slow")});a(window).scroll(function(){var d=window.innerWidth;if(b==0){if(a(this).scrollTop()>100){a(".blog_cookies_div").show()}else{a(".blog_cookies_div").hide()}}})})(jQuery);