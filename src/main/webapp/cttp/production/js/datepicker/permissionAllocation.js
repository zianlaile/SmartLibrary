function permissionsAllocation() {
    var permission  = decimalToBanary(sessionStorage.getItem("permissionAllocate")); // 得到权限数组

    if(permission[0] == 1)
    {
        $("#left-controll").append(" <li><a><div style=\"width:26px;float: left;\"><img src=\"img/lend.png\" style=\"width:18px\"\\></div>借阅数据分析 <span class=\"fa fa-chevron-down\"></span></a>\n" +
            "                                <ul class=\"nav child_menu\">\n" +
            "                                    <li><a href=\"index.html\">图书馆借阅统计</a></li>\n" +
            "                                    <li><a href=\"sml_book_academy_times.html\">学院借还分析</a></li>\n" +
            "                                    <li><a href=\"sml_book_sex_times.html\">性别图书种类分析</a></li>\n" +
            "                                    <li><a href=\"sml_book_publisher_times.html\">借阅出版社排名</a></li>\n" +
            "                                </ul>\n" +
            "                            </li>");
    }
    if(permission[1] == 1)
    {
        $("#left-controll").append(" <li><a><div style=\"width:26px;float: left;\"><img src=\"img/gctrl.png\" style=\"width:18px\"\\></div>进馆数据分析<span class=\"fa fa-chevron-down\"></span></a>\n" +
            "                                <ul class=\"nav child_menu\">\n" +
            "                                    <li><a href=\"sml_gctrl_times.html\">进馆数据统计</a></li>\n" +
            "                                    <li><a href=\"sml_gctrl_day_times.html\">每日进馆人数统计</a></li>\n" +
            "                                    <li><a href=\"sml_gctrl_identity_times.html\">进馆人员分析</a></li>\n" +
            "                                    <!-- <li><a href=\"sml_gctrl_academy_times.html\">进馆学院专业分析</a></li> -->\n" +
            "                                </ul>\n" +
            "                            </li>");
    }
    if(permission[2] == 1)
    {
        $("#left-controll").append("<li><a><div style=\"width:26px;float: left;\"><img src=\"img/IC.png\" style=\"width:18px\"\\></div>IC空间数据分析<span class=\"fa fa-chevron-down\"></span></a>\n" +
            "                                <ul class=\"nav child_menu\">\n" +
            "                                    <li><a href=\"sml_ic_times.html\">IC空间数据统计</a></li>\n" +
            "                                    <li><a href=\"sml_ic_amount_times.html\">IC空间使用量分析</a></li>\n" +
            "                                    <li><a href=\"sml_ic_usetime_times.html\">IC空间使用时长统计</a></li>\n" +
            "                                </ul>\n" +
            "                            </li>");
    }
    if(permission[3] == 1)
    {
        $("#left-controll").append("<li><a><div style=\"width:26px;float: left;\"><img src=\"img/print.png\" style=\"width:18px\"\\></div>自助打印复印分析<span class=\"fa fa-chevron-down\"></span></a>\n" +
            "                                <ul class=\"nav child_menu\">\n" +
            "                                    <li><a href=\"sml_printcs_times.html\">自助文印数据统计</a></li>\n" +
            "                                    <li><a href=\"sml_printcs_pagetype_times.html\">纸张类型统计</a></li>\n" +
            "                                    <li><a href=\"sml_printcs_printtype_times.html\">文印类型统计</a></li>\n" +
            "                                    <!-- <li><a href=\"sml_printcs_location_times.html\">文印地点统计</a></li> -->\n" +
            "                                </ul>\n" +
            "                            </li>");
    }
    if(permission[4] == 1)
    {
        $("#left-controll").append("<li><a><i class=\"fa fa-line-chart\"></i> 统计排行分析 <span class=\"fa fa-chevron-down\"></span></a>\n" +
            "                                <ul class=\"nav child_menu\">\n" +
            "                                    <li><a href=\"sml_ranking_lend_times.html\">借阅统计排行</a></li>\n" +
            "                                    <li><a href=\"sml_ranking_gctrl_times.html\">进馆统计排行</a></li>\n" +
            "                                    <!--<li><a href=\"sml_ranking_seat_times.html\">座位统计排行</a></li>\n" +
            "                                    <li><a href=\"sml_ranking_ic_times.html\">电子阅览室统计排行</a></li>-->\n" +
            "                                    <li><a href=\"sml_ranking_print_times.html\">自助打印统计排行</a></li>\n" +
            "                                </ul>\n" +
            "                            </li>");
    }
    if(permission[5] == 1)
    {
        $("#left-controll").append(" <li><a><i class=\"fa fa-sitemap\"></i> 人员资产统计 <span class=\"fa fa-chevron-down\"></span></a>\n" +
            "                                <ul class=\"nav child_menu\">\n" +
            "                                    <li><a href=\"sml_person_count.html\">图书馆人员统计</a></li>\n" +
            "                                    <li><a href=\"sml_asset_count.html\">图书馆资产统计</a></li>\n" +
            "\n" +
            "                                </ul>\n" +
            "                            </li>");
    }
    if(permission[6] == 1)
    {
        $("#left-controll").append("<li><a><i class=\"fa fa-building-o\"></i> 馆藏资产统计 <span class=\"fa fa-chevron-down\"></span></a>\n" +
            "                                <ul class=\"nav child_menu\">\n" +
            "                                    <li><a href=\"sml_bookcollection_overall.html\">图书馆馆藏总体统计</a></li>\n" +
            "                                    <li><a href=\"sml_bookcollection_newadd.html\">图书馆馆藏新增统计</a></li>\n" +
            "\n" +
            "                                </ul>\n" +
            "                            </li>");
    }
    if(permission[7] == 1)
    {
        $("#left-controll").append("<li><a href=\"../libraryreport/index.html\" target=\"_blank\"><i class=\"fa fa-file-word-o\"></i> 图书馆报告 <span class=\"fa fa-chevron-down\"></span></a>\n" +
            "                            </li>");
    }
    if(permission[8] == 1) {
        $("#left-controll").append("<li><a><i class=\"fa fa-file-word-o\"></i> 图书馆交叉分析 <span class=\"fa fa-chevron-down\"></span></a>\n" +
            "                                <ul class=\"nav child_menu\">\n" +
            "                                    <li><a href=\"#\" target=\"_blank\" id=\"Year1\"></a></li>\n" +
            "                                    <li><a href=\"#\" target=\"_blank\" id=\"Year2\"></a></li>\n" +
            "                                    <li><a href=\"#\" target=\"_blank\" id=\"Year3\"></a></li>\n" +
            "                                    <li><a href=\"#\" target=\"_blank\" id=\"Year4\"></a></li>\n" +
            "                                </ul>\n" +
            "                            </li>");
        var date = new Date();
        var year = date.getFullYear(); //获取当前年份
        var month = date.getMonth() + 1; //获取当前月份
        if(month < 9) year = year - 1;
        $("#Year1").text(year + "年");
        $("#Year1").attr("href","CrossAnalysis.html?year=" + year);
        year--;
        $("#Year2").text(year + "年");
        $("#Year2").attr("href","CrossAnalysis.html?year=" + year);
        year--;
        $("#Year3").text(year + "年");
        $("#Year3").attr("href","CrossAnalysis.html?year=" + year);
        year--;
        $("#Year4").text(year + "年");
        $("#Year4").attr("href","CrossAnalysis.html?year=" + year);
    }
    if(permission[9] == 1)
    {
        $("#left-controll").append("<li><a><i class=\"fa fa-minus-square-o \"></i> 自定义分析 <span class=\"fa fa-chevron-down\"></span></a>\n" +
            "                                <ul class=\"nav child_menu\">\n" +
            "                                    <li><a href=\"sml_defined_book_times.html\">借阅数据分析</a></li>\n" +
            "                                    <li><a href=\"sml_defined_gctrl_times.html\">进馆数据分析</a></li>\n" +
            "                                    <li><a href=\"sml_defined_ic_times.html\">IC空间数据分析</a></li>\n" +
            "                                    <li><a href=\"sml_defined_printcs_times.html\">自助打印复印分析</a></li>\n" +
            "                                    <li><a href=\"sml_defined_person_asset_times.html\">人员资产统计</a></li>\n" +
            "                                    <li><a href=\"sml_defined_ranking_times.html\">统计排行分析</a></li>\n" +
            "                                </ul>\n" +
            "                            </li>");
     }
}

function decimalToBanary(x) {   // 十进制转二进制函数
    var a = x;
    var b = 0;
    var arr = [];
    for(var i = 0;;i++){
        if(a == 0){
            break;
        }else {
            b = a%2;
            a = parseInt(a/2);
            arr.push(b);
        }
    }
    return arr;
}

// 动态加载页面 1: 加载  0: 不加载  数组对应左边得list