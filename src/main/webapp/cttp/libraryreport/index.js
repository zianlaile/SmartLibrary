$(function () {
    getBookLendByAcademy();
    getResourceCountBy_year();//历年馆藏资源统计
    getCollectionOverall();
    getCollectionNewAdded();
    getCollectionNewAddedByCate();
    getCollectionTuShuNewAddedByCate();
    getCollectionWaiWenNewAddedByCate();
    getGctrlsCountBy_year();//历年进馆统计
    getGctrlsCountBy_month();//图书馆门禁按月进馆统计
    getmankindGctrl_Byoneyear();//进馆读者类型比例图
    getmankindCount_Byyear();//进馆读者类型趋势图
    getBook_LendCountBy_year();//历年图书借还总次数
    getBookkindAllCount_Byyear();//读者借阅分类
    getBook_LendCountBy_academyAndyear();//学院借阅
    getbooklendPeopleAndCount_Byhour();//各时段平均借出册数，人数
    getlend_student_type();//各类型读者借阅比例图
    getlendrenew_student_type();//各类型读者续借比例图
    geICdurationCountBy_year();//电子阅览室使用统计
    geICdurationBy_year();//座位在座时长
    geteread_hour();//电子阅览室各时段平均使用次数
    getprintsCountBy_year();//历年文印总量
    getprintsAmountBy_year();
    getprinttimesCountBy_year();//历年打印次数
    getcopytimesCountBy_year();//历年复印次数
    getscantimesCountBy_year();//历年扫描次数
    getprinttimesAmountBy_year();//历年打印次数
    getcopytimesAmountBy_year();//历年复印次数
    getscantimesAmountBy_year();//历年扫描次数
    getprints_hour();//自助文印各时段平均
    readerLend();//读者借阅排名
    bookLend1();//图书借阅排名按册
    bookLend2(); //图书借阅排名按种
    bookLend3();// 最受欢迎的前100本图书   小章定义
    staffLend(); //教职工借阅册数分类
    getpublish_raking();//借阅出版社排名
    getpublish_rating();//借阅出版社比例
    day_gctrl();//当年每日进馆
    dctrl_top12();//排名前12
    getCollectionByPubyear();//图书按出版年份统计表（种/ 册）
    yearUnderGraduatBookLendTop10();  //  本科生借阅最多的10本书
    bookLendFinalRankTop10InGraduate();  // 研究生借阅最多的10本书
    yearLibraryClassifyRankInUndergraduate() // 年度本科生借阅分类排行
    yearLibraryClassifyRankInGraduate()  //  年度研究生借阅分类排行
    $.ajax({
        type:"get",
        contentType: 'application/json',
        url:"../../schoolReport/getICTimesBYTypeOneyear",
        async:false,
        dataType: 'json',
        success: function(data, textStatus, jqXHR){
            month=data.month;
            ereadtimesg=data.ereadtimesg;
            ereadtimeso=data.ereadtimeso;
            ereadtimest=data.ereadtimest;
            ereadtimesu=data.ereadtimesu;
            seattimesg=data.seattimesg;
            seattimeso=data.seattimeso;
            seattimest=data.seattimest;
            seattimesu=data.seattimesu;
            croomtimesg=data.croomtimesg;
            croomtimeso=data.croomtimeso;
            croomtimest=data.croomtimest;
            croomtimesu=data.croomtimesu;
            equipmenttimesg=data.equipmenttimesg;
            equipmenttimeso=data.equipmenttimeso;
            equipmenttimest=data.equipmenttimest;
            equipmenttimesu=data.equipmenttimesu;
            for(var i=0;i<month.length;i++){
                amounteread[i]=Number(ereadtimesg[i])+Number(ereadtimeso[i])+Number(ereadtimest[i])+Number(ereadtimesu[i]);
                amountcroom[i]=Number(croomtimesg[i])+Number(croomtimeso[i])+Number(croomtimest[i])+Number(croomtimesu[i]);
                amountseat[i]=Number(seattimesg[i])+Number(seattimeso[i])+Number(seattimest[i])+Number(seattimesu[i]);
                amountequipment[i]=Number(equipmenttimesg[i])+Number(equipmenttimeso[i])+Number(equipmenttimest[i])+Number(equipmenttimesu[i]);
            }
        }
    });
    croomchart("croom");
    ereadchart("eread");
    seatchart("seat");
    equipmentchart("equipment");
    getCollectionAmountType();
    getCollectionByStackAndBooktype();
    getCollectionBycategory();
    getTop10category();
    library_report_identity_sum(); //各类型读者入馆总人次统计
    library_report_ic_total(); //每月上机人次折线图
    getDailyLendPeopleAndCount(); //每日借出人/册
    getCirculationByHour(); //各时段流通情况（册）
    getLibraryTypeTimes(); //年度全馆扫描、打复印统计
    getUndergraduateBorrowingSituation(); //年度各学院本科生借阅情况
    getGraduateBorrowingSituation(); //年度各学院研究生借阅情况
    getPerCapitaBorrowingAmount(); //各类型读者人均借阅量
    getUndergraduatePerCapitaBorrowingAmount(); //本科生人均借阅量
    getGraduatePerCapitaBorrowingAmount(); //研究生人均借阅量
    getAnnualComparisonofBorrowings(); //本科生、研究生年度对比
});
var month;
var ereadtimesg;
var ereadtimeso;
var ereadtimest;
var ereadtimesu;
var seattimesg;
var seattimeso;
var seattimest;
var seattimesu;
var croomtimesg;
var croomtimeso;
var croomtimest;
var croomtimesu;
var equipmenttimesg;
var equipmenttimeso;
var equipmenttimest;
var equipmenttimesu;
var amounteread=[];
var amountcroom=[];
var amountseat=[];
var amountequipment=[];
function croomchart(chartid){
    var croom_count = echarts.init(document.getElementById(chartid));
    var  croom_count_option ={
        /*backgroundColor: "#344b58",*/
        animation:false,
        "tooltip": {
            "trigger": "axis",
            "axisPointer": {
                "type": "shadow",
                textStyle: {
                    color: "#222"
                }

            },
        },
        /*"grid": {
         "borderWidth": 0,
         "top": 110,
         "bottom": 95,
         textStyle: {
         color: "#222"
         }
         },*/
        "legend": {
            /*right: '10%',*/
            /*top: '11%',*/
            textStyle: {
                color: '#90979c',
            },
            "data": ['本科生', '研究生','教师','其他']
        },


        "calculable": true,
        "xAxis": [{
            "name":"时间",
            "type": "category",
            "axisLine": {
                lineStyle: {
                    color: '#222'
                }
            },
            "splitLine": {
                "show": false
            },
            "axisTick": {
                "show": false
            },
            "axisLabel": {
                rotate:40,
                "interval": 0,

            },
            "data": month,
        }],
        "yAxis": [{
            "name":"人次",
            "type": "value",
            "splitLine": {
                "show": false
            },
            "axisLine": {
                lineStyle: {
                    color: '#222'
                }
            },
            "axisTick": {
                "show": false
            },
            "axisLabel": {
                "interval": 0,

            },
            "splitArea": {
                "show": false
            },

        }],
        /*dataZoom: [{
         type: 'inside',
         start: 70,
         end: 100
         }, {
         start: 70,
         end: 100,
         handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
         handleSize: '80%',
         handleStyle: {
         color: '#fff',
         shadowBlur: 3,
         shadowColor: 'rgba(0, 0, 0, 0.6)',
         shadowOffsetX: 2,
         shadowOffsetY: 2
         }
         }],*/
        "series": [{
            "name": "本科生",
            "type": "bar",
            "stack": "总量",
            "barMaxWidth": 35,
            "barGap": "10%",
            "itemStyle": {
                "normal": {
                    "color": "rgba(255,144,128,1)",
                    "label": {
                        "show": false,
                        "textStyle": {
                            "color": "#fff"
                        },
                        "position": "insideTop",
                        formatter: function(p) {
                            return p.value > 0 ? (p.value) : '';
                        }
                    }
                }
            },
            "data": croomtimesu,
        },

            {
                "name": "研究生",
                "type": "bar",
                "stack": "总量",
                "itemStyle": {
                    "normal": {
                        "color": "rgba(0,191,183,1)",
                        "barBorderRadius": 0,
                        "label": {
                            "show": false,
                            "position": "top",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data": croomtimesg
            },
            {
                "name": "教师",
                "type": "bar",
                "stack": "总量",
                "itemStyle": {
                    "normal": {
                        "color": "rgba(30,144,255,1)",
                        "barBorderRadius": 0,
                        "label": {
                            "show": false,
                            "position": "top",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data": croomtimest
            },{
                "name": "其他",
                "type": "bar",
                "stack": "总量",
                "itemStyle": {
                    "normal": {
                        "color": "rgba(255,165,0,1)",
                        "barBorderRadius": 0,
                        "label": {
                            "show": false,
                            "position": "top",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data": croomtimeso
            },{
                "name": "总数",
                "type": "line",
                "stack": "总量",
                symbolSize:10,
                symbol:'circle',
                "itemStyle": {
                    "normal": {
                        "color": "rgba(30,144,255,1)",
                        "barBorderRadius": 0,
                        "label": {
                            "show": true,
                            "position": "top",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data":amountcroom
            },
        ]
    };
    croom_count.setOption(croom_count_option);
}
function ereadchart(chartid){
    var eread_count = echarts.init(document.getElementById(chartid));
    var  eread_count_option ={
        /*backgroundColor: "#344b58",*/
        animation:false,
        "tooltip": {
            "trigger": "axis",
            "axisPointer": {
                "type": "shadow",
                textStyle: {
                    color: "#222"
                }

            },
        },
        /*"grid": {
         "borderWidth": 0,
         "top": 110,
         "bottom": 95,
         textStyle: {
         color: "#fff"
         }
         },*/
        "legend": {
            /*right: '10%',*/
            /*top: '11%',*/
            textStyle: {
                color: '#90979c',
            },
            "data": ['本科生', '研究生','教师','其他']
        },


        "calculable": true,
        "xAxis": [{
            "name":"时间",
            "type": "category",
            "axisLine": {
                lineStyle: {
                    color: '#222'
                }
            },
            "splitLine": {
                "show": false
            },
            "axisTick": {
                "show": false
            },
            "splitArea": {
                "show": false
            },
            "axisLabel": {
                rotate:40,
                "interval": 0,

            },
            "data": month,
        }],
        "yAxis": [{
            "name":"人次",
            "type": "value",
            "splitLine": {
                "show": false
            },
            "axisLine": {
                lineStyle: {
                    color: '#222'
                }
            },
            "axisTick": {
                "show": false
            },
            "axisLabel": {
                "interval": 0,

            },
            "splitArea": {
                "show": false
            },

        }],
        /*dataZoom: [{
         type: 'inside',
         start: 70,
         end: 100
         }, {
         start: 70,
         end: 100,
         handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
         handleSize: '80%',
         handleStyle: {
         color: '#fff',
         shadowBlur: 3,
         shadowColor: 'rgba(0, 0, 0, 0.6)',
         shadowOffsetX: 2,
         shadowOffsetY: 2
         }
         }],*/
        "series": [{
            "name": "本科生",
            "type": "bar",
            "stack": "总量",
            "barMaxWidth": 35,
            "barGap": "10%",
            "itemStyle": {
                "normal": {
                    "color": "rgba(255,144,128,1)",
                    "label": {
                        "show": false,
                        "textStyle": {
                            "color": "#fff"
                        },
                        "position": "insideTop",
                        formatter: function(p) {
                            return p.value > 0 ? (p.value) : '';
                        }
                    }
                }
            },
            "data": ereadtimesu,
        },

            {
                "name": "研究生",
                "type": "bar",
                "stack": "总量",
                "itemStyle": {
                    "normal": {
                        "color": "rgba(0,191,183,1)",
                        "barBorderRadius": 0,
                        "label": {
                            "show": false,
                            "position": "top",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data": ereadtimesg
            },
            {
                "name": "教师",
                "type": "bar",
                "stack": "总量",
                "itemStyle": {
                    "normal": {
                        "color": "rgba(30,144,255,1)",
                        "barBorderRadius": 0,
                        "label": {
                            "show": false,
                            "position": "top",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data": ereadtimest
            },{
                "name": "其他",
                "type": "bar",
                "stack": "总量",
                "itemStyle": {
                    "normal": {
                        "color": "rgba(255,165,0,1)",
                        "barBorderRadius": 0,
                        "label": {
                            "show": false,
                            "position": "top",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data": ereadtimeso
            },{
                "name": "总数",
                "type": "line",
                "stack": "总量",
                symbolSize:10,
                symbol:'circle',
                "itemStyle": {
                    "normal": {
                        "color": "rgba(30,144,255,1)",
                        "barBorderRadius": 0,
                        "label": {
                            "show": true,
                            "position": "top",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data":amounteread
            },
        ]
    };
    eread_count.setOption(eread_count_option);
}
function seatchart(chartid){
    var seat_count = echarts.init(document.getElementById(chartid));
    var  seat_count_option ={
        /*backgroundColor: "#344b58",*/
        animation:false,
        "tooltip": {
            "trigger": "axis",
            "axisPointer": {
                "type": "shadow",
                textStyle: {
                    color: "#222"
                }

            },
        },
        /*"grid": {
         "borderWidth": 0,
         "top": 110,
         "bottom": 95,
         textStyle: {
         color: "#222"
         }
         },*/
        "legend": {
            /*right: '10%',*/
            /*top: '11%',*/
            textStyle: {
                color: '#90979c',
            },
            "data": ['本科生', '研究生','教师','其他']
        },


        "calculable": true,
        "xAxis": [{
            "name":"时间",
            "type": "category",
            "axisLine": {
                lineStyle: {
                    color: '#222'
                }
            },
            "splitLine": {
                "show": false
            },
            "axisTick": {
                "show": false
            },
            "splitArea": {
                "show": false
            },
            "axisLabel": {
                rotate:40,
                "interval": 0,

            },
            "data": month,
        }],
        "yAxis": [{
            "name":"人次",
            "type": "value",
            "splitLine": {
                "show": false
            },
            "axisLine": {
                lineStyle: {
                    color: '#222'
                }
            },
            "axisTick": {
                "show": false
            },
            "axisLabel": {
                "interval": 0,

            },
            "splitArea": {
                "show": false
            },

        }],
        /*dataZoom: [{
         type: 'inside',
         start: 70,
         end: 100
         }, {
         start: 70,
         end: 100,
         handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
         handleSize: '80%',
         handleStyle: {
         color: '#fff',
         shadowBlur: 3,
         shadowColor: 'rgba(0, 0, 0, 0.6)',
         shadowOffsetX: 2,
         shadowOffsetY: 2
         }
         }],*/
        "series": [{
            "name": "本科生",
            "type": "bar",
            "stack": "总量",
            "barMaxWidth": 35,
            "barGap": "10%",
            "itemStyle": {
                "normal": {
                    "color": "rgba(255,144,128,1)",
                    "label": {
                        "show": false,
                        "textStyle": {
                            "color": "#fff"
                        },
                        "position": "insideTop",
                        formatter: function(p) {
                            return p.value > 0 ? (p.value) : '';
                        }
                    }
                }
            },
            "data": seattimesu,
        },

            {
                "name": "研究生",
                "type": "bar",
                "stack": "总量",
                "itemStyle": {
                    "normal": {
                        "color": "rgba(0,191,183,1)",
                        "barBorderRadius": 0,
                        "label": {
                            "show": false,
                            "position": "top",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data": seattimesg
            },
            {
                "name": "教师",
                "type": "bar",
                "stack": "总量",
                "itemStyle": {
                    "normal": {
                        "color": "rgba(30,144,255,1)",
                        "barBorderRadius": 0,
                        "label": {
                            "show": false,
                            "position": "top",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data": seattimest
            },{
                "name": "其他",
                "type": "bar",
                "stack": "总量",
                "itemStyle": {
                    "normal": {
                        "color": "rgba(255,165,0,1)",
                        "barBorderRadius": 0,
                        "label": {
                            "show": false,
                            "position": "top",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data": seattimeso
            },{
                "name": "总数",
                "type": "line",
                "stack": "总量",
                symbolSize:10,
                symbol:'circle',
                "itemStyle": {
                    "normal": {
                        "color": "rgba(30,144,255,1)",
                        "barBorderRadius": 0,
                        "label": {
                            "show": true,
                            "position": "top",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data":amountseat
            },
        ]
    };
    seat_count.setOption(seat_count_option);
}
function equipmentchart(chartid){
    var equipment_count = echarts.init(document.getElementById(chartid));
    var  equipment_count_option ={
        /*backgroundColor: "#344b58",*/
        animation:false,
        "tooltip": {
            "trigger": "axis",
            "axisPointer": {
                "type": "shadow",
                textStyle: {
                    color: "#222"
                }

            },
        },
        /*"grid": {
         "borderWidth": 0,
         "top": 110,
         "bottom": 95,
         textStyle: {
         color: "#222"
         }
         },*/
        "legend": {
            /*right: '10%',*/
            /*top: '11%',*/
            textStyle: {
                color: '#90979c',
            },
            "data": ['本科生', '研究生','教师','其他']
        },


        "calculable": true,
        "xAxis": [{
            "name":"时间",
            "type": "category",
            "axisLine": {
                lineStyle: {
                    color: '#222'
                }
            },
            "splitLine": {
                "show": false
            },
            "axisTick": {
                "show": false
            },
            "splitArea": {
                "show": false
            },
            "axisLabel": {
                rotate:40,
                "interval": 0,

            },
            "data": month,
        }],
        "yAxis": [{
            "name":"人次",
            "type": "value",
            "splitLine": {
                "show": false
            },
            "axisLine": {
                lineStyle: {
                    color: '#222'
                }
            },
            "axisTick": {
                "show": false
            },
            "axisLabel": {
                "interval": 0,

            },
            "splitArea": {
                "show": false
            },

        }],
        /*dataZoom: [{
         type: 'inside',
         start: 70,
         end: 100
         }, {
         start: 70,
         end: 100,
         handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
         handleSize: '80%',
         handleStyle: {
         color: '#fff',
         shadowBlur: 3,
         shadowColor: 'rgba(0, 0, 0, 0.6)',
         shadowOffsetX: 2,
         shadowOffsetY: 2
         }
         }],*/
        "series": [{
            "name": "本科生",
            "type": "bar",
            "stack": "总量",
            "barMaxWidth": 35,
            "barGap": "10%",
            "itemStyle": {
                "normal": {
                    "color": "rgba(255,144,128,1)",
                    "label": {
                        "show": false,
                        "textStyle": {
                            "color": "#fff"
                        },
                        "position": "insideTop",
                        formatter: function(p) {
                            return p.value > 0 ? (p.value) : '';
                        }
                    }
                }
            },
            "data": equipmenttimesu,
        },

            {
                "name": "研究生",
                "type": "bar",
                "stack": "总量",
                "itemStyle": {
                    "normal": {
                        "color": "rgba(0,191,183,1)",
                        "barBorderRadius": 0,
                        "label": {
                            "show": false,
                            "position": "top",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data": equipmenttimesg
            },
            {
                "name": "教师",
                "type": "bar",
                "stack": "总量",
                "itemStyle": {
                    "normal": {
                        "color": "rgba(30,144,255,1)",
                        "barBorderRadius": 0,
                        "label": {
                            "show": false,
                            "position": "top",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data": equipmenttimest
            },{
                "name": "其他",
                "type": "bar",
                "stack": "总量",
                "itemStyle": {
                    "normal": {
                        "color": "rgba(255,165,0,1)",
                        "barBorderRadius": 0,
                        "label": {
                            "show": false,
                            "position": "top",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data": equipmenttimeso
            },{
                "name": "总数",
                "type": "line",
                "stack": "总量",
                symbolSize:10,
                symbol:'circle',
                "itemStyle": {
                    "normal": {
                        "color": "rgba(30,144,255,1)",
                        "barBorderRadius": 0,
                        "label": {
                            "show": true,
                            "position": "top",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data":amountequipment
            },
        ]
    };
    equipment_count.setOption(equipment_count_option);
}
function day_gctrl() {
    $.get('../../gctrl/ByDay2?'+nowyear).done(function (resultdata) {
        // 填入数据
        var day_gctrl = echarts.init(document.getElementById('day_gctrl'));
        var gctrl_times=resultdata.gctrl_times;
        var times=resultdata.times;
        var year=resultdata.year[0];
        if(typeof(year)=="undefined"){
            var date=new Date;
            year=year=date.getFullYear();
        }
        var data=[];
        for(var i=0;i<times.length;i++){
            var onedata=[];
            onedata.push(times[i]);
            onedata.push(gctrl_times[i]);
            data.push(onedata);
        }
        var day_count_option_option = {
            // backgroundColor: '#404a59',
            /*title: {
             top: 30,
             text: year+'年每天进馆人数',
             left: 'center',
             textStyle: {
             }
             },*/
            animation:false,
            tooltip : {
                trigger: 'item',
                position: 'top',
                formatter: function (params) {
                    // console.log(params);
                    //return "000"
                    return params.data[0] + '     进馆' +':'+ params.data[1]+ '人' ;
                }
            },
            legend: {
                top: '30',
                left: '100',
                data:['人数'],
                textStyle: {
                    // color: '#fff'
                }
            },
            calendar: [{
                top: 100,
                left: 'center',
                range: [year+'-01-01', year+'-06-30'],
                dayLabel:{nameMap : 'cn'},
                monthLabel :{nameMap : 'cn'},
                splitLine: {
                    show: true,
                    lineStyle: {
                        color: '#000',
                        width: 4,
                        type: 'solid'
                    }
                },
                yearLabel: {
                    formatter: '{start} 上半年',
                    textStyle: {
                        color: '#fff'
                    }
                },
                itemStyle: {
                    normal: {
                        //color: '#323c48',
                        borderWidth: 1,
                        borderColor: '#111'
                    }
                }
            }, {
                top: 340,
                left: 'center',
                range: [year+'-07-01', year+'-12-31'],
                dayLabel:{nameMap : 'cn'},
                monthLabel :{nameMap : 'cn'},
                splitLine: {
                    show: true,
                    lineStyle: {
                        color: '#000',
                        width: 4,
                        type: 'solid'
                    }
                },
                yearLabel: {
                    formatter: '{start} 下半年',
                    textStyle: {
                        color: '#fff'
                    }
                },
                itemStyle: {
                    normal: {
                        // color: '#323c48',
                        borderWidth: 1,
                        borderColor: '#111'
                    }
                }
            }],
            series : [
                {
                    name: '人数',
                    type: 'scatter',
                    coordinateSystem: 'calendar',
                    data: data,
                    symbolSize: function (val) {
                        return val[1] / 500;
                    },
                    itemStyle: {
                        normal: {
                            color: '#ddb926'
                        }
                    }
                },
                {
                    name: '人数',
                    type: 'scatter',
                    coordinateSystem: 'calendar',
                    calendarIndex: 1,
                    data: data,
                    symbolSize: function (val) {
                        return val[1] / 500;
                    },
                    itemStyle: {
                        normal: {
                            color: '#ddb926'
                        }
                    }
                },
            ]
        };
        day_gctrl.setOption(day_count_option_option);
    });
}
function dctrl_top12() {
    var gctrl_top12 = echarts.init(document.getElementById('gctrl_top12'));
    $.get('../../gctrl/ByDay_count2?'+nowyear).done(function (resultdata) {
        // 填入数据
        var day_count2_option = {
            animation:false,
            legend: {
                data: ['日进馆排名'],
                align: 'left'
            },
            grid: {
                left: '10%',
                right: '10%',
                containLabel: true
            },
            tooltip: {},
            xAxis: {
                data: resultdata.time,
                'axisLabel': {
                    rotate:30,
                    'interval': 0
                },
                silent: false,
                splitLine: {
                    show: false
                }
            },
            yAxis: {
            },
            series: [{
                name: '日进馆排名',
                type: 'bar',
                data: resultdata.gctrl_times,
                itemStyle:{
                    normal:{
                        color:'#45e4cb',
                    }
                },
                animationDelay: function (idx) {
                    return idx * 10;
                }
            }],
            animationEasing: 'elasticOut',
            animationDelayUpdate: function (idx) {
                return idx * 5;
            }
        };
        gctrl_top12.setOption(day_count2_option);
    });
}
function getpublish_raking() {
    $.ajax({
        type:'get',
        url:'../../bookLend/ByPublisher',
        contentType:'application/json',
        async:false,
        dataType:'json',
        success:function (data) {
            for(var key in data){
            }
            var option = {
                animation:false,
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'shadow'
                    },
                    formatter: "{a} <br/>{b} : {c}次"
                },
                legend: {
                    data: ['借阅出版社排名']
                },
                grid: {
                    top:'0%',
                    left: '3%',
                    right: '4%',
                    bottom:'0%',
                    containLabel: true
                },
                xAxis: {
                    type: 'value',
                    boundaryGap: [0, 0.01],
                    "axisLabel": {
                        "interval": 0,
                        formatter: '{value}次',
                    }
                },
                yAxis: {
                    type: 'category',
                    data: data[key].publisher
                },
                series: [{
                    name: '借阅出版社排名',
                    type: 'bar',
                    data: data[key].times
                }]
            };
            var chart = echarts.init(document.getElementById('publisher_raking'));
            chart.setOption(option);
        }
    })
}
function getpublish_rating() {
    $.ajax({
        type:'get',
        url:'../../bookLend/ByPublisher',
        contentType:'application/json',
        async:false,
        dataType:'json',
        success:function (data) {
            for(var key in data){
            }
            var piedatalist = [];
            for (var k = 0; k < data[key].publisher.length; k++) {
                var piedata = {};
                piedata.value = data[key].times[k];
                piedata.name = data[key].publisher[k];
                piedatalist.push(piedata);
            }
            var option = {
                animation:false,
                tooltip: {
                    trigger: 'item',
                    formatter: "借阅量<br/>{b} : {c} ({d}%)"
                },
                legend: {
                    top: 'center',
                    left: 20,
                    orient: 'vertical',
                    bottom: 20,
                    data: data[key].publisher
                },
                calculable: true,
                series: [
                    {
                        name: '面积模式',
                        type: 'pie',
                        radius: [30, 130],
                        center: ['50%', '50%'],
                        roseType: 'area',
                        label: {
                            normal: {
                                show: false
                            },
                            emphasis: {
                                show: true
                            }
                        },
                        lableLine: {
                            normal: {
                                show: false
                            },
                            emphasis: {
                                show: true
                            }
                        },
                        data: piedatalist
                    }
                ]
            };
            var chart = echarts.init(document.getElementById('publisher_rating'));
            chart.setOption(option);
        }
    })
}
function downloadword(){
    var img_Book_Amount =echarts.init(document.getElementById("getResourceCountBy_year")).getDataURL();
    var img_gctrl_amount =echarts.init(document.getElementById("getGctrlsCountBy_year")).getDataURL();
    var img_month_amount =echarts.init(document.getElementById("getGctrlsCountBy_month")).getDataURL();
    var img_type_percent1 =echarts.init(document.getElementById("getmankindGctrl_Byoneyear")).getDataURL();
    var img_type_percent2 =echarts.init(document.getElementById("getmankindCount_Byyear")).getDataURL();
    var img_lend_yearamount =echarts.init(document.getElementById("getBook_LendCountBy_year")).getDataURL();
    var img_type_reader =echarts.init(document.getElementById("getBookkindAllCount_Byyear")).getDataURL();
    var img_academy_img =echarts.init(document.getElementById("getBook_LendCountBy_academyAndyear")).getDataURL();
    var img_leader_img =echarts.init(document.getElementById("getbooklendPeopleAndCount_Byhour")).getDataURL();
    var img_borrow_img1 =echarts.init(document.getElementById("getlend_student_type")).getDataURL();
    var img_borrow_img2 =echarts.init(document.getElementById("getlendrenew_student_type")).getDataURL();
    var img_read_img =echarts.init(document.getElementById("geICdurationCountBy_year")).getDataURL();
    var img_seat_img =echarts.init(document.getElementById("geICdurationBy_year")).getDataURL();
    var img_ebook_spend =echarts.init(document.getElementById("geteread_hour")).getDataURL();
    var img_print_amount =echarts.init(document.getElementById("getprintsCountBy_year")).getDataURL();
    var img_print_dy =echarts.init(document.getElementById("getprinttimesCountBy_year")).getDataURL();
    var img_print_fy =echarts.init(document.getElementById("getcopytimesCountBy_year")).getDataURL();
    var img_print_sm =echarts.init(document.getElementById("getscantimesCountBy_year")).getDataURL();
    var img_print_pageamount =echarts.init(document.getElementById("getprintsAmountBy_year")).getDataURL();
    var img_print_pagedy =echarts.init(document.getElementById("getprinttimesAmountBy_year")).getDataURL();
    var img_print_pagefy =echarts.init(document.getElementById("getcopytimesAmountBy_year")).getDataURL();
    var img_print_pagesm =echarts.init(document.getElementById("getscantimesAmountBy_year")).getDataURL();
    var img_print_day =echarts.init(document.getElementById("getprints_hour")).getDataURL();
    var publisher_rating =echarts.init(document.getElementById("publisher_rating")).getDataURL();
    var publisher_raking =echarts.init(document.getElementById("publisher_raking")).getDataURL();
    var gctrl_top12 =echarts.init(document.getElementById("gctrl_top12")).getDataURL();
    var day_gctrl =echarts.init(document.getElementById("day_gctrl")).getDataURL();
    var croom =echarts.init(document.getElementById("croom")).getDataURL();
    var eread =echarts.init(document.getElementById("eread")).getDataURL();
    var seat =echarts.init(document.getElementById("seat")).getDataURL();
    var equipment =echarts.init(document.getElementById("equipment")).getDataURL();
    var typechart = echarts.init(document.getElementById("typechart")).getDataURL();
    var typenumber = echarts.init(document.getElementById("typenumber")).getDataURL();
    var getCollectionBycategorytype = echarts.init(document.getElementById("getCollectionBycategorytype")).getDataURL();
    var getCollectionBycategorynumber = echarts.init(document.getElementById("getCollectionBycategorynumber")).getDataURL();
    var getCollectionOverall = echarts.init(document.getElementById("getCollectionOverall")).getDataURL();
    var getCollectionNewAdded = echarts.init(document.getElementById("getCollectionNewAdded")).getDataURL();
    var getCollectionNewAddedByCate = echarts.init(document.getElementById("getCollectionNewAddedByCate")).getDataURL();
    var getCollectionTuShuNewAddedByCate = echarts.init(document.getElementById("getCollectionTuShuNewAddedByCate")).getDataURL();
    var getCollectionWaiWenNewAddedByCate = echarts.init(document.getElementById("getCollectionWaiWenNewAddedByCate")).getDataURL();
    var img_academy_top1 = echarts.init(document.getElementById("getBookLendByAcademyFirst")).getDataURL();
    var img_academy_top2 = echarts.init(document.getElementById("getBookLendByAcademySecond")).getDataURL();
    var img_academy_top3 = echarts.init(document.getElementById("getBookLendByAcademyThird")).getDataURL();
    try{
        /* 第一版导出word
         var elemIF = document.createElement("iframe");
         elemIF.src = "../../report/2.docx";
         elemIF.style.display = "none";
         document.body.appendChild(elemIF);*/
        replace["Library_Introduce"] = document.getElementById("introduce").innerHTML;
        replace["img_Book_Amount"] = img_Book_Amount;
        replace["img_gctrl_amount"] = img_gctrl_amount;
        replace["img_month_amount"] = img_month_amount;
        replace["img_type_percent1"] = img_type_percent1;
        replace["img_type_percent2"] = img_type_percent2;
        replace["img_lend_yearamount"] = img_lend_yearamount;
        replace["img_type_reader"] = img_type_reader;
        replace["img_leader_img"] = img_leader_img;
        replace["img_borrow_img1"] = img_borrow_img1;
        replace["img_borrow_img2"] = img_borrow_img2;
        replace["img_read_img"] = img_read_img;
        replace["img_seat_img"] = img_seat_img;
        replace["img_ebook_spend"] = img_ebook_spend;
        replace["img_print_amount"] = img_print_amount;
        replace["img_print_dy"] = img_print_dy;
        replace["img_print_fy"] = img_print_fy;
        replace["img_print_sm"] = img_print_sm;
        replace["img_print_pageamount"] = img_print_pageamount;
        replace["img_print_pagedy"] = img_print_pagedy;
        replace["img_print_pagefy"] = img_print_pagefy;
        replace["img_print_pagesm"] = img_print_pagesm;
        replace["img_print_day"] = img_print_day;
        replace["day_gctrl"] = day_gctrl;
        replace["gctrl_top12"] = gctrl_top12;
        replace["publisher_raking"] = publisher_raking;
        replace["publisher_rating"] = publisher_rating;
        replace["croom"] = croom;
        replace["eread"] = eread;
        replace["seat"] = seat;
        replace["equipment"] = equipment;
        replace["typechart"] = typechart;
        replace["typenumber"] = typenumber;
        replace["getCollectionBycategorytype"] = getCollectionBycategorytype;
        replace["getCollectionBycategorynumber"] = getCollectionBycategorynumber;
        replace["getCollectionOverall"] = getCollectionOverall;
        replace["getCollectionNewAdded"] = getCollectionNewAdded;
        replace["getCollectionNewAddedByCate"] = getCollectionNewAddedByCate
        replace["getCollectionTuShuNewAddedByCate"] = getCollectionTuShuNewAddedByCate;
        replace["getCollectionWaiWenNewAddedByCate"] = getCollectionWaiWenNewAddedByCate;
        replace["img_academy_img"] = img_academy_img;
        replace["img_academy_top1"] = img_academy_top1;
        replace["img_academy_top2"] = img_academy_top2;
        replace["img_academy_top3"] = img_academy_top3;
        replace["barchart_library_report_identity_sum"] = echarts.init(document.getElementById("barchart_library_report_identity_sum")).getDataURL();
        replace["piechart1_library_report_identity_sum"] = echarts.init(document.getElementById("piechart1_library_report_identity_sum")).getDataURL();
        replace["piechart2_library_report_identity_sum"] = echarts.init(document.getElementById("piechart2_library_report_identity_sum")).getDataURL();
        replace["piechart3_library_report_identity_sum"] = echarts.init(document.getElementById("piechart3_library_report_identity_sum")).getDataURL();
        replace["getUndergraduateBorrowingSituation"] = echarts.init(document.getElementById("getUndergraduateBorrowingSituation")).getDataURL();
        replace["getGraduateBorrowingSituation"] = echarts.init(document.getElementById("getGraduateBorrowingSituation")).getDataURL();
        replace["getPerCapitaBorrowingAmount"] = echarts.init(document.getElementById("getPerCapitaBorrowingAmount")).getDataURL();
        replace["getUndergraduatePerCapitaBorrowingAmount"] = echarts.init(document.getElementById("getUndergraduatePerCapitaBorrowingAmount")).getDataURL();
        replace["getGraduatePerCapitaBorrowingAmount"] = echarts.init(document.getElementById("getGraduatePerCapitaBorrowingAmount")).getDataURL();
        replace["getDailyLendPeopleAndCount"] = echarts.init(document.getElementById("getDailyLendPeopleAndCount")).getDataURL();
        replace["getCirculationByHour"] = echarts.init(document.getElementById("getCirculationByHour")).getDataURL();
        replace["library_report_ic_total"] = echarts.init(document.getElementById("library_report_ic_total")).getDataURL();
        replace["library_report_ic_total_2"] = echarts.init(document.getElementById("library_report_ic_total_2")).getDataURL();
        replace["getSumCopyByYearTimes"] = echarts.init(document.getElementById("getSumCopyByYearTimes")).getDataURL();
        replace["getSumPrintByYearTimes"] = echarts.init(document.getElementById("getSumPrintByYearTimes")).getDataURL();
        replace["getSumScanningByYearTimes"] = echarts.init(document.getElementById("getSumScanningByYearTimes")).getDataURL();
        replace["getSumCopyByYearNum"] = echarts.init(document.getElementById("getSumCopyByYearNum")).getDataURL();
        replace["getSumPrintByYearNum"] = echarts.init(document.getElementById("getSumPrintByYearNum")).getDataURL();
        replace["getSumScanningByYearNum"] = echarts.init(document.getElementById("getSumScanningByYearNum")).getDataURL();
        XDoc.key = "62b523oxpzbypoc6vmxuak2lqi";
        XDoc.run("http://106.14.120.137:8080/SmartLibrary/report/88.docx","docx",
            replace ,"_blank");
    }catch(e){

    }
}
function getResourceCountBy_year() {
    $.ajax({
        type:'get',
        url:'../../schoolReport/getResourceCountBy_year',
        contentType: 'application/json',
        async:false,
        dataType: 'json',
        success: function(data, textStatus, jqXHR){
            var year = [];
            var count = [];
            var count1 = [];
            for(var i=0;i<data.length;i++){
                year.push(data[i].year);
                count.push({
                    value:data[i].count,
                    itemStyle:{
                        normal:{
                            color:'orange'

                        }
                    }
                });
                count1.push(data[i].count)
            }
            var getResourceCountBy_year = echarts.init(document.getElementById('getResourceCountBy_year'));
            var option = {
                backgroundColor:'white',
                animation:false,
                xAxis: [
                    {
                        name:'年',
                        type: 'category',
                        show:true,
                        data: year,
                        axisPointer: {
                            type: 'shadow'
                        },
                        axisLabel:{
                            interval:0,
                            rotate:60,
                        },
                        axisTick: {
                            show: false
                        },
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        name: '资源数（册）',
                        /*min: 0,
                        max:100,
                        interval: 20,*/
                        axisLabel: {
                            formatter: '{value}'
                        },
                        axisTick: {
                            show: false
                        }
                    },

                ],
                series: [
                    {
                        /*name:'保障率',*/
                        type:'bar',
                        barWidth: '30%',
                        data:count,
                        label: {
                            normal: {
                                show: true,
                                position: 'top',
                                formatter: '{c}'
                            }
                        },
                    },

                    {
                        type:'line',
                        name:'占比',
                        data:count1
                    }
                ],
            };
            getResourceCountBy_year.setOption(option);
        }
    });
}
function getGctrlsCountBy_year() {
    $.ajax({
        type:'get',
        url:'../../schoolReport/getGctrlsCountBy_year',
        contentType:'application/json',
        async:false,
        dataType:'json',
        success:function (data) {
            var year = [];
            var gctrl = [];
            for(var i=0;i<data.length;i++){
                year.push(data[i].year);
                gctrl.push(data[i].gctrls);
            }
            var max = Max(gctrl);
            $(".gctrl-intro").find(".first-year").text(data[0].year);
            $(".gctrl-intro").find(".last-year").text(data[data.length - 1].year);
            $(".gctrl-intro").find(".max-year").text(year[parseInt(max.p)]);
            $(".gctrl-intro").find(".max-num").text(max.num);
            replace["gctrl_year1"] = data[0].year;
            replace["gctrl_year2"] = data[data.length - 1].year;
            replace["gctrl_year3"] = year[parseInt(max.p)];
            replace["gctrl_amount"] = max.num;
            var getgetGctrlsCountBy_year = echarts.init(document.getElementById('getGctrlsCountBy_year'));
            var GctrlsCountBy_yearoption = {
                animation:false,
                backgroundColor:'white',
                color: ['#3398DB'],
                tooltip : {
                    trigger: 'axis',
                    axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                        type : 'line'        // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                grid: {
                    left: '2%',
                    right: '8%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis : [
                    {
                        name:'年',
                        type : 'category',
                        data : year,
                        axisTick: {
                            alignWithLabel: true
                        }
                    }
                ],
                yAxis : [
                    {
                        // type : 'category',
                        // data : ['10','20','30','40'],
                        name:"人次",
                        axisTick: {
                            alignWithLabel: true
                        }
                    }
                ],
                series : [
                    {
                        name:'进馆人次',
                        type:'bar',
                        barWidth: '40%',
                        data:gctrl
                    }

                ],
                label: {
                    normal: {
                        show: true,
                        position: 'top',
                        formatter: '{c}'
                    }
                },
                itemStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: 'rgba(17, 168,171, 1)'
                        }, {
                            offset: 1,
                            color: 'rgba(17, 168,171, 0.1)'
                        }]),
                        shadowColor: 'rgba(0, 0, 0, 0.1)',
                        shadowBlur: 10
                    }
                }
            };
            getgetGctrlsCountBy_year.setOption(GctrlsCountBy_yearoption);
        }
    });

}
function getGctrlsCountBy_month() {
    $.ajax({
        type:'get',
        contentType:'application/json',
        url:'../../schoolReport/getGctrlsCountBy_month',
        dataType:'json',
        async:false,
        success:function (data) {
            var month = [];
            var gctrl_times = [];
            for(var i=0;i<data.length;i++){
                month.push(data[i].month+'月');
                gctrl_times.push(data[i].gctrl_times);
            }
            var max = Max(gctrl_times);
            $(".month-gctrl").find(".first-year").text(data[0].year);
            $(".month-gctrl").find(".first-month").text(data[0].month);
            $(".month-gctrl").find(".last-year").text(data[data.length - 1].year);
            $(".month-gctrl").find(".last-month").text(data[data.length - 1].month);
            $(".month-gctrl").find(".total").text(Sum(gctrl_times));
            $(".month-gctrl").find(".max-month").text(month[parseInt(max.p)]);
            replace["gctrl_month_year1"] = data[0].year;
            replace["gctrl_month_month1"] = data[0].month;
            replace["gctrl_month_year2"] = data[data.length - 1].year;
            replace["gctrl_month_month2"] = data[data.length - 1].month;
            replace["gctrl_month_amount"] = Sum(gctrl_times);
            replace["gctrl_month_month3"] = month[parseInt(max.p)];
            replace["img_title_year"] = data[0].year;
            var getGctrlsCountBy_month = echarts.init(document.getElementById('getGctrlsCountBy_month'));
            var getGctrlsCountBy_monthoption = {
                animation:false,
                backgroundColor:'white',
                tooltip : {
                    trigger: 'axis'
                },
                grid:{
                  left:'12%'
                },
                calculable : true,
                xAxis : [
                    {
                        name:'月',
                        type : 'category',
                        data : month,
                        axisLabel:{interval:0}
                    }
                ],
                yAxis : [
                    {
                        name:'人次',
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:'进馆人次',
                        type:'bar',
                        barWidth:'40%',
                        data:gctrl_times,
                        itemStyle: {
                            normal: {
                                color: function(params) {
                                    // build a color map as your need.
                                    var colorList = [
                                        '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B',
                                        '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',
                                        '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'
                                    ];
                                    return colorList[params.dataIndex]
                                },label: {
                                    show: true,
                                    position: 'top',
                                    formatter: '{c}'
                                }
                            }
                        }
                    }
                ]
            };
            getGctrlsCountBy_month.setOption(getGctrlsCountBy_monthoption);
        }
    });
}
function getmankindGctrl_Byoneyear() {
    $.ajax({
        type:'get',
        contentType:'application/json',
        url:'../../schoolReport/getmankindCount_Byoneyear',
        async:false,
        dataType:'json',
        success:function(data){
            var gctrldata = [];
            var type=[];
            var gctrlNum=[];
            for(var i=0;i<data.length;i++){
                gctrldata.push({
                    value:data[i].gctrl,
                    name:data[i].man_kind
                });
                type.push(data[i].man_kind);
                gctrlNum.push(data[i].gctrl);
            }
            var max = Max(gctrlNum);
            var total = Sum(gctrlNum);
            $(".gctrl-type").find(".max-type").text(type[parseInt(max.p)]);
            $(".gctrl-type").find(".max-num").text((max.num/total*100).toFixed(2));
            replace["gctrl_type_year1"] = data[0].year;
            replace["gctrl_type_student"] = type[parseInt(max.p)];
            replace["gctrl_type_percent"] = (max.num/total*100).toFixed(2);
            replace["img_type_year"] = data[0].year;
            var getmankindGctrl_Byoneyear = echarts.init(document.getElementById('getmankindGctrl_Byoneyear'));
            var getmankindGctrl_Byoneyearoption = {
                animation:false,
                backgroundColor:'white',
                tooltip : {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                calculable : true,
                series : [
                    {
                        name:data[0].year+'年',
                        type:'pie',
                        radius : [60, 100],
                        center : ['50%', '50%'],
                        roseType : 'radius',
                        data:gctrldata
                    }
                ]
            };
            getmankindGctrl_Byoneyear.setOption(getmankindGctrl_Byoneyearoption);
        }
    })
}
function getmankindCount_Byyear() {
    $.ajax({
        type:'get',
        contentType:'application/json',
        url:'../../schoolReport/getmankindCount_Byyear',
        dataType:'json',
        async:false,
        success:function (data) {
            var getmankindCount_Byyearyear = new Array();
            var mankinddata = [];
            var other = [];
            var student = [];
            var teacher = [];
            var gradute = [];
            for(var i=0;i<data.length;i++){
                if($.inArray(data[i].year, getmankindCount_Byyearyear)==-1){
                    getmankindCount_Byyearyear.push(data[i].year);
                }
                if(data[i].man_kind=='其他'){
                    other.push(data[i].gctrl);
                }
                else if(data[i].man_kind=='教职工'){
                    teacher.push(data[i].gctrl);
                }
                else if(data[i].man_kind=='本科生'){
                    student.push(data[i].gctrl);
                }
                else if(data[i].man_kind=='研究生'){
                    gradute.push(data[i].gctrl);
                }
            }
            mankinddata.push({
                name:'其他',
                type:'line',
                data:other
            });
            mankinddata.push({
                name:'教职工',
                type:'line',
                data:teacher
            });
            mankinddata.push({
                name:'本科生',
                type:'line',
                data:student
            });
            mankinddata.push({
                name:'研究生',
                type:'line',
                data:gradute
            });
            var getmankindCount_Byyear = echarts.init(document.getElementById('getmankindCount_Byyear'));
            var getmankindCount_Byyearoption = {
                animation:false,
                backgroundColor:'white',
                xAxis: {
                    name:'年',
                    data:getmankindCount_Byyearyear
                },
                grid:{
                  left:'14%',
                  right:'8%',
                  bottom:'10%'
                },
                legend: {
                    top:'5%',
                    align: 'right',
                    data: ['其他','教职工','本科生','研究生'],
                    textStyle: {
                        align: 'right',
                        baseline: 'middle',
                        fontFamily: 'IRANSans'
                    }
                },
                yAxis: {
                    name:'人次'
                },
                series: mankinddata
            };
            getmankindCount_Byyear.setOption(getmankindCount_Byyearoption);
        }
    })
}
function getBook_LendCountBy_year() {
    $.ajax({
        type:'get',
        contentType:'application/json',
        url:'../../schoolReport/getBook_LendCountBy_year',
        async:false,
        dataType:'json',
        success:function (data) {
            var book_lend_year = [];
            var book_lend_times = [];
            var book_return_times = [];
            var book_total=[];
            for(var i=0;i<data.length;i++){
                book_lend_year.push(data[i].year);
                book_lend_times.push(data[i].book_lend_times);
                book_return_times.push(data[i].book_return_times);
                book_total.push(data[i].book_lend_times+data[i].book_return_times);
            }
            var max= Max(book_total);
            $(".lend-return").find(".max-year").text(book_lend_year[max.p]);
            $(".lend-return").find(".max-total").text(max.num);
            replace["lend_top1_year"] = book_lend_year[max.p];
            replace["lend_top1_amount"] = max.num;
            var secYear;
            var sortTotal = book_total.sort();
            for(var i=0;i<data.length;i++){
                if(book_total[i]==sortTotal[sortTotal.length-2]){
                    secYear = data[i].year;
                }
            }
            $(".lend-return").find(".sec-year").text(secYear);
            $(".lend-return").find(".sec-total").text(sortTotal[sortTotal.length-2]);
            replace["lend_top2_year"] = secYear;
            replace["lend_top2_amount"] = sortTotal[sortTotal.length-2];
            var getBook_LendCountBy_year = echarts.init(document.getElementById('getBook_LendCountBy_year'));
            var getBook_LendCountBy_yearoption ={
                animation:false,
                color:['#63C2FF','#FFCB8C'],
                backgroundColor:'white',
                tooltip : {
                    trigger: 'axis',
                    axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                        type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                legend: {
                    top:'5%',
                    data: ['借书', '还书']
                },
                grid: {
                    left: '3%',
                    right: '8%',
                    bottom: '3%',
                    containLabel: true
                },
                yAxis:  {
                    name:'册',
                    type: 'value'
                },
                xAxis: {
                    name:'年',
                    type: 'category',
                    data: book_lend_year
                },
                series: [
                    {
                        name: '借书',
                        type: 'bar',
                        stack: '总量',
                        barWidth:'40%',
                        label: {
                            normal: {
                                show: true,
                                position: 'inside',
                                color:'#666'
                            }
                        },
                        data: book_lend_times
                    },
                    {
                        name: '还书',
                        type: 'bar',
                        stack: '总量',
                        barWidth:'40%',
                        label: {
                            normal: {
                                show: true,
                                position: 'inside',
                                color:'#666'
                            }
                        },
                        data: book_return_times
                    }
                ]
            };
            getBook_LendCountBy_year.setOption(getBook_LendCountBy_yearoption);
        }
    })
}
function getBookkindAllCount_Byyear() {
    $.ajax({
        type:'get',
        contentType:'application/json',
        url:'../../schoolReport/getBookkindAllCount_Byyear',
        async:false,
        dataType:'json',
        success:function (data) {
            var bookkind = [];
            var bookkinddata = [];
            for(var i=0;i<data.length;i++){
                bookkind.push(data[i].book_kind);
                bookkinddata.push(data[i].book_lend_times);
            }
            var max = Max(bookkinddata);
            $(".lend-type").find(".max-type").text(bookkind[parseInt(max.p)]);
            $(".lend-type").find(".max-num").text(max.num);
            var sortLend = sortByKey(data,'book_lend_times');
            $(".lend-type").find(".sec-type").text(sortLend[sortLend.length-2].book_kind);
            $(".lend-type").find(".sec-num").text(sortLend[sortLend.length-2].book_lend_times);

            replace["lend_book_year"] = data[0].year;
            replace["lend_book_type1"] = bookkind[parseInt(max.p)];
            replace["lend_book_time1"] = max.num;
            replace["lend_book_type2"] = sortLend[sortLend.length-2].book_kind;
            replace["lend_book_time2"] = sortLend[sortLend.length-2].book_lend_times;
            replace["img_type_year"] = data[0].year;
            var getBookkindAllCount_Byyear = echarts.init(document.getElementById('getBookkindAllCount_Byyear'));
            var getBookkindAllCount_Byyearoption = {
                //color: ['#3398DB'],
                animation:false,
                tooltip: {
                    trigger: 'axis',
                    backgroundColor:'rgba(255,255,255,0.8)',
                    extraCssText: 'box-shadow: 0 0 8px rgba(0, 0, 0, 0.3);',
                    textStyle:{
                        color:'#6a717b',
                    },

                },
                grid: {
                    left: '2%',
                    right: '8%',
                    bottom: '5%',
                    containLabel: true
                },
                yAxis: [{
                    name:'借阅类别',
                    type: 'category',
                    data: bookkind,
                    axisTick: {
                        alignWithLabel: true
                    },
                    axisLabel: {
                        margin: 10,
                        textStyle: {
                            fontSize: 12,
                            color:'#94999f'
                        }
                    },
                    axisLine: {
                        lineStyle: {
                            color: '#999'
                        }
                    }

                }],
                xAxis: [{
                    type: 'value',
                    axisLabel: {
                        margin: 10,
                        textStyle: {
                            fontSize: 12,
                            color:'#94999f'
                        }
                    },
                    axisLine: {
                        lineStyle: {
                            color: '#fff'
                        }
                    },
                    splitLine: {
                        lineStyle: {
                            color: '#dbe0e6'
                        }
                    }



                }],
                backgroundColor: '#ffffff',
                series: [{
                    name: 'Top 10',
                    type: 'bar',
                    barWidth:'80%',
                    data: bookkinddata,
                    label: {
                        normal: {
                            show: false,
                            position: 'insideRight',
                            textStyle: {
                                color: '#666', //color of value
                                position:'right'
                            }
                        }
                    },


                    itemStyle: {

                        normal: {
                            color: new echarts.graphic.LinearGradient(0, 0, 1, 0, [{
                                offset: 0,
                                color: '#64bdc8' // 0% 处的颜色
                            }, {
                                offset: 1,
                                color: '#00c484' // 100% 处的颜色
                            }], false),
                            barBorderRadius: [0, 15,15, 0],
                            shadowColor: 'rgba(0,0,0,0.1)',
                            shadowBlur: 3,
                            shadowOffsetY: 3
                        }
                    }
                }]
            };
            getBookkindAllCount_Byyear.setOption(getBookkindAllCount_Byyearoption);
        }
    })
}
function getBook_LendCountBy_academyAndyear() {
    $.ajax({
        type:'get',
        contentType:'application/json',
        url:'../../schoolReport/getBook_LendCountBy_academyAndyear',
        dataType:'json',
        async:false,
        success:function (data) {
            var academy = [];
            var academylend = [];
            for(var i=0;i<data.length;i++){
                academy.push(data[i].academy);
                academylend.push(data[i].lend);
            }
            $(".academy-lend").find(".max-name").text(academy[0]);
            $(".academy-lend").find(".sec-name").text(academy[1]);
            $(".academy-lend").find(".third-name").text(academy[2]);
            replace["img_academy_year"] = data[0].year;
            replace["lend_top3_accdemy1"] = academy[0];
            replace["lend_top3_accdemy2"] = academy[1];
            replace["lend_top3_accdemy3"] = academy[2];
            var getBook_LendCountBy_academyAndyear = echarts.init(document.getElementById('getBook_LendCountBy_academyAndyear'));
            var getBook_LendCountBy_academyAndyearoption = {
                animation:false,
                backgroundColor:'white',
                color: ['#3398DB'],
                tooltip : {
                    trigger: 'axis',
                    axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                        type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                grid: {
                    left: '3%',
                    right: '10%',
                    bottom: '13%',
                    containLabel: true
                },
                xAxis : [
                    {
                        name:'学院',
                        type : 'category',
                        data : academy,
                        axisTick: {
                            alignWithLabel: true
                        },
                        "axisLabel": {
                            "interval": 0,
                            "rotate": 30,
                            "show": true,
                            "splitNumber": 10,
                            "textStyle": {
                                "fontFamily": "黑体",
                                "fontSize": 12
                            }
                        }
                    }
                ],
                yAxis : [
                    {
                        // type : 'category',
                        // data : ['10','20','30','40'],
                        name:'册',
                        axisTick: {
                            alignWithLabel: true
                        }
                    }
                ],
                series : [
                    {
                        name:'借阅',
                        type:'bar',
                        barWidth: '40%',
                        data:academylend
                    },

                ],
                label: {
                    normal: {
                        show: true,
                        position: 'top',
                        formatter: '{c}'
                    }
                },
                itemStyle: {
                    normal: {

                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: 'rgba(17, 168,171, 1)'
                        }, {
                            offset: 1,
                            color: 'rgba(17, 168,171, 0.1)'
                        }]),
                        shadowColor: 'rgba(0, 0, 0, 0.1)',
                        shadowBlur: 10
                    }
                }
            };
            getBook_LendCountBy_academyAndyear.setOption(getBook_LendCountBy_academyAndyearoption);
        }

    })

}
function getbooklendPeopleAndCount_Byhour() {
    $.ajax({
        type:'get',
        contentType:'application/json',
        url:'../../schoolReport/getbooklendPeopleAndCount_Byhour',
        dataType:'json',
        async:false,
        success:function (data) {
            var booklendhour = [];
            var lendpeople = [];
            var lendbookdata = [];
            for(var i=0;i<data.length;i++){
                booklendhour.push(data[i].hour+"点");
                lendpeople.push(data[i].lend_people);
                lendbookdata.push(data[i].lend);
            }
            var hour = [];
            var lend = [];
            var lendpeople = [];
            for(var i=0;i<data.length;i++){
                hour.push(data[i].hour);
                lend.push(data[i].lend);
                lendpeople.push(data[i].lend_people);
            }
            var max_lend = Math.max.apply(Math,lend);//借阅册数
            var lend_hour =hour[lend.indexOf(max_lend)];//借阅量的高峰期 lend_hour点-lend_hour+1点
            var max_lend_people = Math.max.apply(Math,lendpeople);//借阅人数
            var people_hour = hour[lendpeople.indexOf(max_lend_people)];//借阅人次最多时段 people_hour点-people_hour+1点
            $(".average-lend").find(".first-hour").text(lend_hour);
            $(".average-lend").find(".next-hour").text(lend_hour+1);
            $(".average-lend").find(".first-num").text(max_lend);
            $(".average-lend").find(".max-hour").text(people_hour);
            $(".average-lend").find(".second-hour").text(people_hour+1);
            $(".average-lend").find(".second-num").text(max_lend_people);
            replace["library_leader_year"] = data[0].year;
            replace["library_leader_clock1"] = lend_hour;
            replace["library_leader_clock2"] = lend_hour+1;
            replace["library_book_amount"] = max_lend;
            replace["library_lead_clock3"] = people_hour;
            replace["library_lead_clock4"] = people_hour+1;
            replace["library_leader_amount"] = max_lend_people;
            replace["img_leader_year"] = data[0].year;
            var getbooklendPeopleAndCount_Byhour = echarts.init(document.getElementById('getbooklendPeopleAndCount_Byhour'));
            var getbooklendPeopleAndCount_Byhouroption = {
                animation:false,
                backgroundColor: 'white',
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        lineStyle: {
                            color: '#57617B'
                        }
                    }
                },
                legend: {
                    icon: 'rect',
                    itemWidth: 14,
                    itemHeight: 5,
                    itemGap: 13,
                    top:'5%',
                    data: ['借出册数', '借出人数'],
                    right: 'center'
                },
                grid: {
                    left: '2%',
                    right: '10%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis: [{
                    name:'小时',
                    type: 'category',
                    boundaryGap: false,
                    axisLine: {
                        lineStyle: {
                            color: '#57617B'
                        }
                    },
                    data: booklendhour
                }],
                yAxis: [{
                    type: 'value',
                    axisTick: {
                        show: false
                    },
                    axisLine: {
                        lineStyle: {
                            color: '#57617B'
                        }
                    },
                    axisLabel: {
                        margin: 10,
                        textStyle: {
                            fontSize: 14
                        }
                    },
                    splitLine: {
                        lineStyle: {
                            color: '#57617B'
                        },
                        show:false,
                    }
                }],
                series: [{
                    name: '借出册数',
                    type: 'line',
                    smooth: true,
                    lineStyle: {
                        normal: {
                            width: 1
                        }
                    },
                    areaStyle: {
                        normal: {
                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                offset: 0,
                                color: 'rgba(17, 168, 171, 1)'
                            }, {
                                offset: 0.8,
                                color: 'rgba(17, 168, 171, 0.3)'
                            }], false),
                            shadowColor: 'rgba(0, 0, 0, 0.1)',
                            shadowBlur: 10
                        }
                    },
                    itemStyle: {
                        normal: {
                            color: 'rgb(17, 168, 171)',
                            borderColor: 'rgba(17,168,171,0.27)',
                            borderWidth: 6
                        }
                    },
                    data: lendbookdata
                }, {
                    name: '借出人数',
                    type: 'line',
                    smooth: true,
                    lineStyle: {
                        normal: {
                            width: 1
                        }
                    },
                    areaStyle: {
                        normal: {
                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                offset: 0,
                                color: 'rgba(255, 69, 0, 1)'
                            }, {
                                offset: 0.8,
                                color: 'rgba(255, 69, 0, 0.3)'
                            }], false),
                            shadowColor: 'rgba(0, 0, 0, 0.1)',
                            shadowBlur: 10
                        }
                    },
                    itemStyle: {
                        normal: {
                            color: 'rgb(255,69,0)',
                            borderColor: 'rgba(255,69,0,0.2)',
                            borderWidth: 6

                        }
                    },
                    data: lendpeople
                } ]
            };
            getbooklendPeopleAndCount_Byhour.setOption(getbooklendPeopleAndCount_Byhouroption);
        }
    })
}
function getlend_student_type(){
    $.ajax({
        type:'get',
        contentType:'application/json',
        url:'../../schoolReport/getmankindCount_Byoneyear',
        async:false,
        dataType:'json',
        success:function (data) {
            var colorList = [
                '#59c5a7', '#51b8fe', '#fa827d','#FFCC67'
            ];
            // 总和
            var total = {
                name: '总借阅数',
                value: data[0].lend+data[1].lend+data[2].lend+data[3].lend
            }
            var originalData = [{
                value: data[0].lend,
                name: '其他：'+data[0].lend
            }, {
                value: data[1].lend,
                name: '教职工：'+data[1].lend
            }, {
                value: data[2].lend,
                name: "本科生："+data[2].lend
            }, {
                value: data[3].lend,
                name: "研究生："+data[3].lend
            }
            ];
            var sortData = sortByKey(data,'lend');
            var num = sortData[sortData.length-1].lend;
            $(".type-rate").find(".max-type").text(sortData[sortData.length-1].man_kind);
            $(".type-rate").find(".max-num").text((num/total.value*100).toFixed(2));
            replace["student_borrow_type"] = sortData[sortData.length-1].man_kind;
            replace["student_borrow_percent"] = (num/total.value*100).toFixed(2);
            replace["student_borrow_year"] = data[0].year;
            replace["img_borrow_year1"] = data[0].year;
            replace["img_borrow_year2"] = data[0].year;
            echarts.util.each(originalData, function(item, index) {
                item.itemStyle = {
                    normal: {
                        color: colorList[index]
                    }
                };
            });
            var getlend_student_typeoption = {
                animation:false,
                backgroundColor:'white',
                title: [{
                    text: total.name,
                    left: '49%',
                    top: '40%',
                    textAlign: 'center',
                    textBaseline: 'middle',
                    textStyle: {
                        color: '#999',
                        fontWeight: 'normal',
                        fontSize: 18
                    }
                }, {
                    text: total.value,
                    left: '49%',
                    top: '51%',
                    textAlign: 'center',
                    textBaseline: 'middle',
                    textStyle: {
                        color: '#666',
                        fontWeight: 'normal',
                        fontSize: 40
                    }
                }],
                series: [{
                    hoverAnimation: false, //设置饼图默认的展开样式
                    radius: [80, 100],
                    name: 'pie',
                    type: 'pie',
                    selectedMode: 'single',
                    selectedOffset: 16, //选中是扇区偏移量
                    clockwise: true,
                    startAngle: 90,
                    label: {
                        normal: {
                            textStyle: {
                                fontSize: 16,
                                color: '#999'
                            }
                        }
                    },
                    labelLine: {
                        normal: {
                            lineStyle: {
                                color: '#999',

                            }
                        }
                    },
                    data: originalData
                }]
            };
            var getlend_student_type = echarts.init(document.getElementById('getlend_student_type'));
            getlend_student_type.setOption(getlend_student_typeoption);
        }
    })
}
function getlendrenew_student_type(){
    $.ajax({
        type:'get',
        contentType:'application/json',
        url:'../../schoolReport/getmankindCount_Byoneyear',
        async:false,
        dataType:'json',
        success:function (data) {
            var colorList = [
                '#59c5a7', '#51b8fe', '#fa827d','#FFCC67'
            ];

            // 总和
            var total = {
                name: '总续借数',
                value: data[0].renew+data[1].renew+data[2].renew+data[3].renew
            };

            var originalData = [{
                value: data[0].renew,
                name: '其他：'+data[0].renew
            }, {
                value: data[1].renew,
                name: '教职工：'+data[1].renew
            }, {
                value: data[2].renew,
                name: "本科生："+data[2].renew
            }, {
                value: data[3].renew,
                name: "研究生："+data[3].renew
            },
            ];
            echarts.util.each(originalData, function(item, index) {
                item.itemStyle = {
                    normal: {
                        color: colorList[index]
                    }
                };
            });
            var getlendrenew_student_typeoption = {
                animation:false,
                backgroundColor:'white',
                title: [
                    {
                        text: total.name,
                        left: '49%',
                        top: '45%',
                        textAlign: 'center',
                        textBaseline: 'middle',
                        textStyle: {
                            color: '#999',
                            fontWeight: 'normal',
                            fontSize: 20
                        }
                    },
                    {
                        text: total.value,
                        left: '49%',
                        top: '55%',
                        textAlign: 'center',
                        textBaseline: 'middle',
                        textStyle: {
                            color: '#666',
                            fontWeight: 'normal',
                            fontSize: 30
                        }
                    }],
                series: [{
                    hoverAnimation: false, //设置饼图默认的展开样式
                    radius: [80, 100],
                    name: 'pie',
                    type: 'pie',
                    selectedMode: 'single',
                    selectedOffset: 16, //选中是扇区偏移量
                    clockwise: true,
                    startAngle: 90,
                    label: {
                        normal: {
                            textStyle: {
                                fontSize: 16,
                                color: '#999'
                            }
                        }
                    },
                    labelLine: {
                        normal: {
                            lineStyle: {
                                color: '#999',

                            }
                        }
                    },
                    data: originalData
                }]
            };
            var getlendrenew_student_type = echarts.init(document.getElementById('getlendrenew_student_type'));
            getlendrenew_student_type.setOption(getlendrenew_student_typeoption);
        }
    })
}
function geICdurationCountBy_year() {
    $.ajax({
        type:'get',
        contentType:'application/json',
        url:'../../schoolReport/geICdurationCountBy_year',
        dataType:'json',
        async:false,
        success:function (data) {
            var icdurationmonth = [];
            var idduration_times = [];
            for(var i=0;i<data.length;i++){
                icdurationmonth.push(data[i].month+'月');
                idduration_times.push(data[i].eread_times);
            }
            var sortData = sortByKey(data,'eread_times');
            $(".eread-info").find(".max-month").text(sortData[sortData.length-1].month);
            $(".eread-info").find(".max-num").text(sortData[sortData.length-1].eread_times);
            replace["eread_read_year"] = data[0].year;
            replace["img_read_year"] = data[0].year;
            replace["eread_read_month"] = sortData[sortData.length-1].month;
            replace["eread_read_time"] = sortData[sortData.length-1].eread_times;
            var geICdurationCountBy_year = echarts.init(document.getElementById('geICdurationCountBy_year'));
            var geICdurationCountBy_yearoption = {
                animation:false,
                backgroundColor:'white',
                tooltip : {
                    trigger: 'axis'
                },
                calculable : true,
                xAxis : [
                    {
                        name:'月',
                        type : 'category',
                        data : icdurationmonth
                    }
                ],
                yAxis : [
                    {
                        name:'次',
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:'电子阅览室',
                        type:'bar',
                        data:idduration_times,
                        itemStyle: {
                            normal: {
                                color: function(params) {
                                    // build a color map as your need.
                                    var colorList = [
                                        '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B',
                                        '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',
                                        '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'
                                    ];
                                    return colorList[params.dataIndex]
                                },label: {
                                    show: true,
                                    position: 'top',
                                    formatter: '{b}\n{c}'
                                }
                            }
                        }
                    }
                ]
            };
            geICdurationCountBy_year.setOption(geICdurationCountBy_yearoption);
        }
    });
}
function geICdurationBy_year(){
    $.ajax({
        type:'get',
        contentType:'application/json',
        url:'../../schoolReport/geICdurationBy_year',
        async:false,
        dataType:'json',
        success:function (data) {
            var colorList = [
                '#59c5a7', '#51b8fe', '#fa827d','#FFCC67'
            ];

            // 总和
            var total = {
                name: '总次数',
                value: data[0].lessone+data[0].onetotwo+data[0].twotofive+data[0].morefive
            }

            var originalData = [{
                value: data[0].lessone,
                name: '小于1小时：'+data[0].lessone
            }, {
                value: data[0].onetotwo,
                name: '1-2小时：'+data[0].onetotwo
            }, {
                value: data[0].twotofive,
                name: "2-5小时："+data[0].twotofive
            }, {
                value: data[0].morefive,
                name: "5小时以上："+data[0].morefive
            }
            ];
            echarts.util.each(originalData, function(item, index) {
                item.itemStyle = {
                    normal: {
                        color: colorList[index]
                    }
                };
            });
            var geICdurationBy_yearoption = {
                animation:false,
                backgroundColor:'white',
                title: [
                    {
                    text: total.name,
                    left: '49%',
                    top: '46%',
                    textAlign: 'center',
                    textBaseline: 'middle',
                    textStyle: {
                        color: '#999',
                        fontWeight: 'normal',
                        fontSize: 20
                    }
                },
                    {
                    text: total.value,
                    left: '49%',
                    top: '51%',
                    textAlign: 'center',
                    textBaseline: 'middle',
                    textStyle: {
                        color: '#666',
                        fontWeight: 'normal',
                        fontSize: 30
                    }
                }],
                grid:{
                    left:'15%',
                    right:'15%'
                },
                series: [{
                    hoverAnimation: false, //设置饼图默认的展开样式
                    radius: [100, 120],
                    name: 'pie',
                    type: 'pie',
                    selectedMode: 'single',
                    selectedOffset: 16, //选中是扇区偏移量
                    clockwise: true,
                    startAngle: 90,
                    label: {
                        normal: {
                            textStyle: {
                                fontSize: 14,
                                color: '#999'
                            }
                        }
                    },
                    labelLine: {
                        normal: {
                            lineStyle: {
                                color: '#999'

                            }
                        }
                    },
                    data: originalData
                }]
            };
            var geICdurationBy_year = echarts.init(document.getElementById('geICdurationBy_year'));
            geICdurationBy_year.setOption(geICdurationBy_yearoption);
        }
    })
}
function geteread_hour() {
    $.ajax({
        type:'get',
        contentType:'application/json',
        url:'../../schoolReport/getDeviceCount_Byhour',
        dataType:'json',
        async:false,
        success:function (data) {
            var ereadshour = [];
            var ereadshourtimes = [];
            for(var i=0;i<data.length;i++){
                ereadshour.push(data[i].hour);
                ereadshourtimes.push(data[i].ereads);
            }
            var max_ereads = Math.max.apply(Math,ereadshourtimes);
            var ereads_hour =ereadshour[ereadshourtimes.indexOf(max_ereads)];//电子阅览室的高峰期 lend_hour点-lend_hour+1点
            $(".eread-info").find(".max-hour").text(ereads_hour);
            $(".eread-info").find(".next-hour").text(ereads_hour+1);
            replace["ebook_spent_clock1"] = ereads_hour+"点";
            replace["ebook_spent_clock2"] = ereads_hour+1+"点";
            var geteread_hour = echarts.init(document.getElementById('geteread_hour'));
            var geteread_houroption = {
                animation:false,
                backgroundColor:'white',
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    top:'3%',
                    data: ['使用次数']
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis: {
                    type: 'category',
                    boundaryGap: false,
                    data: ereadshour,
                    splitLine: { //设置X轴的网格
                        show: true,
                        interval: 'auto'
                    },
                    axisLine: { //设置X轴的颜色
                        lineStyle: {
                            color: 'blue'
                        }
                    }
                },
                yAxis: {
                    type: 'value',
                    axisLine: { //设置y轴的颜色
                        lineStyle: {
                            color: 'blue'
                        }
                    }
                },
                series: [{
                    name: '使用次数',
                    type: 'line',
                    stack: '总量',
                    smooth: true, //点与点之间的幅度,false为直线
                    // symbol: 'circle',
                    // symbolSize: 5,
                    // showSymbol: true,   //是否显示点数据的圆点
                    // itemStyle: {    //设置折线的border颜色
                    //     normal: {
                    //         color: 'rgb(0,136,212)',
                    //         borderColor: 'rgba(0,136,212,0.2)',
                    //         borderWidth: 10
                    //     }
                    // },
                    label: { //设置点数据的提示
                        normal: {
                            show: true,
                            position: 'top'
                        }
                    },
                    data: ereadshourtimes,
                    markPoint: { //设置最大值和最小值
                        data: [{
                            type: 'max',
                            name: '最大值'
                        }, {
                            type: 'min',
                            name: '最小值'
                        }]
                    }

                }]
            };
            geteread_hour.setOption(geteread_houroption);
        }
    })
}
function getprintsCountBy_year() {
    $.ajax({
        type:'get',
        url:'../../printtimes/byyear',
        contentType:'application/json',
        async:false,
        dataType:'json',
        success:function (data) {
            var year = data.year;
            var num = data.printtimes;
            var thisNum = num[num.length-1];
            var beforeNum = num[num.length-2];
            var variableNum = thisNum - beforeNum;
            if(variableNum<0){
                $(".total-print").find(".variable-type").text("减少");
                replace["print_amount_page2"] = "减少";
            }
            else if(variableNum>0){
                $(".total-print").find(".variable-type").text("增加");
                replace["print_amount_page2"] = "增加";
            }
            $(".total-print").find(".this-year").text(year[year.length-1]);
            $(".total-print").find(".this-num").text(num[num.length-1]);
            $(".total-print").find(".variable-num").text(Math.abs(variableNum));
            replace["print_amount_year"] = year[year.length-1];
            replace["print_amount_page1"] = num[num.length-1];
            replace["print_amount_page3"] = Math.abs(variableNum);
            var getprintsCountBy_year = echarts.init(document.getElementById('getprintsCountBy_year'));
            var getprintsCountBy_yearoption = {
                animation:false,
                backgroundColor:'white',
                color: ['#3398DB'],
                tooltip : {
                    trigger: 'axis',
                    axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                        type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                grid: {
                    left: '3%',
                    right: '8%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis : [
                    {
                        name:'年',
                        type : 'category',
                        data : data.year,
                        axisTick: {
                            alignWithLabel: true
                        }
                    }
                ],
                yAxis : [
                    {
                        // type : 'category',
                        // data : ['10','20','30','40'],
                        name:"人次",
                        axisTick: {
                            alignWithLabel: true
                        }
                    }
                ],
                series : [
                    {
                        name:'自主文印次数',
                        type:'bar',
                        barWidth: '40%',
                        data:data.printtimes
                    },

                ],
                label: {
                    normal: {
                        show: true,
                        position: 'top',
                        formatter: '{c}'
                    }
                },
                itemStyle: {
                    normal: {

                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: 'rgba(17, 168,171, 1)'
                        }, {
                            offset: 1,
                            color: 'rgba(17, 168,171, 0.1)'
                        }]),
                        shadowColor: 'rgba(0, 0, 0, 0.1)',
                        shadowBlur: 10
                    }
                }
            };
            getprintsCountBy_year.setOption(getprintsCountBy_yearoption);
        }
    });

}
function getprintsAmountBy_year() {
    $.ajax({
        type:'get',
        url:'../../printtimes/amountbyyear',
        contentType:'application/json',
        async:false,
        dataType:'json',
        success:function (data) {
            var year = data.year;
            var num = data.printtimes;
            var thisNum = num[num.length-1];
            var beforeNum = num[num.length-2];
            var variableNum = thisNum - beforeNum;
            if(variableNum<0){
                $(".total-print-amount").find(".variable-type-amount").text("减少");
                replace["print_pageamount_page2"] = "减少";
            }
            else if(variableNum>0){
                $(".total-print-amount").find(".variable-type-amount").text("增加");
                replace["print_pageamount_page2"] = "增加";
            }
            $(".total-print-amount").find(".this-year-amount").text(year[year.length-1]);
            $(".total-print-amount").find(".this-num-amount").text(num[num.length-1]);
            $(".total-print-amount").find(".variable-num-amount").text(Math.abs(variableNum));
            replace["print_pageamount_year"] = year[year.length-1];
            replace["print_pageamount_page1"] = num[num.length-1];
            replace["print_pageamount_page3"] = Math.abs(variableNum);
            var getprintsAmountBy_year = echarts.init(document.getElementById('getprintsAmountBy_year'));
            var getprintsAmountBy_yearoption = {
                animation:false,
                backgroundColor:'white',
                color: ['#3398DB'],
                tooltip : {
                    trigger: 'axis',
                    axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                        type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                grid: {
                    left: '3%',
                    right: '8%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis : [
                    {
                        name:'年',
                        type : 'category',
                        data : data.year,
                        axisTick: {
                            alignWithLabel: true
                        }
                    }
                ],
                yAxis : [
                    {
                        // type : 'category',
                        // data : ['10','20','30','40'],
                        name:"页数",
                        axisTick: {
                            alignWithLabel: true
                        }
                    }
                ],
                series : [
                    {
                        name:'自主文印页数',
                        type:'bar',
                        barWidth: '40%',
                        data:data.printtimes
                    },

                ],
                label: {
                    normal: {
                        show: true,
                        position: 'top',
                        formatter: '{c}'
                    }
                },
                itemStyle: {
                    normal: {

                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: 'rgba(17, 168,171, 1)'
                        }, {
                            offset: 1,
                            color: 'rgba(17, 168,171, 0.1)'
                        }]),
                        shadowColor: 'rgba(0, 0, 0, 0.1)',
                        shadowBlur: 10
                    }
                }
            };
            getprintsAmountBy_year.setOption(getprintsAmountBy_yearoption);
        }
    });

}
function getprinttimesCountBy_year() {
    $.ajax({
        type:'get',
        url:'../../schoolReport/gettypeprints',
        contentType: 'application/json',
        async:false,
        dataType: 'json',
        success: function(data, textStatus, jqXHR){
            var count = [];
            for(var i=0;i<data.print.length;i++){
                count.push({
                    value:data.print[i],
                    itemStyle:{
                        normal:{
                            color:'#C8B2F4'
                        }
                    }
                });
            }
            var getprinttimesCountBy_year = echarts.init(document.getElementById('getprinttimesCountBy_year'));
            var getprinttimesCountBy_yearoption = {
                animation:false,
                backgroundColor:'white',
                xAxis: [
                    {
                        name:'年',
                        type: 'category',
                        show:true,
                        data: data.year,
                        axisPointer: {
                            type: 'shadow'
                        },
                        axisTick: {
                            show: false
                        },
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        name: '打印次数',
                        /*min: 0,
                         max:100,
                         interval: 20,*/
                        axisLabel: {
                            formatter: '{value}'
                        },
                        axisTick: {
                            show: false
                        }
                    },

                ],
                grid:{
                    left:'12%',
                    right:'10%',
                    bottom:'10%'
                },
                series: [
                    {
                        /*name:'保障率',*/
                        type:'bar',
                        barWidth: '30%',
                        data:count,
                        label: {
                            normal: {
                                show: true,
                                position: 'top',
                                formatter: '{c}'
                            }
                        },
                    },

                    {
                        type:'line',
                        name:'占比',
                        data:data.print
                    }
                ],
            };
            getprinttimesCountBy_year.setOption(getprinttimesCountBy_yearoption);
        }
    });
}
function getcopytimesCountBy_year() {
    $.ajax({
        type:'get',
        url:'../../schoolReport/gettypeprints',
        contentType: 'application/json',
        async:false,
        dataType: 'json',
        success: function(data, textStatus, jqXHR){
            var count = [];
            for(var i=0;i<data.copy.length;i++){
                count.push({
                    value:data.copy[i],
                    itemStyle:{
                        normal:{
                            color:'#32DADD'

                        }
                    }
                });
            }
            var getcopytimesCountBy_year = echarts.init(document.getElementById('getcopytimesCountBy_year'));
            var getcopytimesCountBy_yearoption = {
                backgroundColor:'white',
                animation:false,
                xAxis: [
                    {
                        name:'年',
                        type: 'category',
                        show:true,
                        data: data.year,
                        axisPointer: {
                            type: 'shadow'
                        },
                        axisTick: {
                            show: false
                        },
                    }
                ],

                yAxis: [
                    {
                        type: 'value',
                        name: '复印次数',
                        /*min: 0,
                         max:100,
                         interval: 20,*/
                        axisLabel: {
                            formatter: '{value}'
                        },
                        axisTick: {
                            show: false
                        }
                    },

                ],
                series: [
                    {
                        /*name:'保障率',*/
                        type:'bar',
                        barWidth: '30%',
                        data:count,
                        label: {
                            normal: {
                                show: true,
                                position: 'top',
                                formatter: '{c}'
                            }
                        },
                    },

                    {
                        type:'line',
                        name:'占比',
                        data:data.copy
                    }
                ],
            };
            getcopytimesCountBy_year.setOption(getcopytimesCountBy_yearoption);
        }
    });
}
function getscantimesCountBy_year() {
    $.ajax({
        type:'get',
        url:'../../schoolReport/gettypeprints',
        contentType: 'application/json',
        async:false,
        dataType: 'json',
        success: function(data, textStatus, jqXHR){
            var count = [];
            for(var i=0;i<data.scan.length;i++){
                count.push({
                    value:data.scan[i],
                    itemStyle:{
                        normal:{
                            color:'#FF3292'

                        }
                    }
                });
            }
            var getscantimesCountBy_year = echarts.init(document.getElementById('getscantimesCountBy_year'));
            var getscantimesCountBy_yearoption = {
                animation:false,
                backgroundColor:'white',
                xAxis: [
                    {
                        name:'年',
                        type: 'category',
                        show:true,
                        data: data.year,
                        axisPointer: {
                            type: 'shadow'
                        },
                        axisTick: {
                            show: false
                        },
                    }
                ],

                yAxis: [
                    {
                        type: 'value',
                        name: '扫描次数',
                        /*min: 0,
                         max:100,
                         interval: 20,*/
                        axisLabel: {
                            formatter: '{value}'
                        },
                        axisTick: {
                            show: false
                        }
                    },

                ],
                series: [
                    {
                        /*name:'保障率',*/
                        type:'bar',
                        barWidth: '30%',
                        data:count,
                        label: {
                            normal: {
                                show: true,
                                position: 'top',
                                formatter: '{c}'
                            }
                        },
                    },

                    {
                        type:'line',
                        name:'占比',
                        data:data.scan
                    }
                ],
            };
            getscantimesCountBy_year.setOption(getscantimesCountBy_yearoption);
        }
    });
}
function getprinttimesAmountBy_year() {
    $.ajax({
        type:'get',
        url:'../../schoolReport/gettypeprintsamount',
        contentType: 'application/json',
        async:false,
        dataType: 'json',
        success: function(data, textStatus, jqXHR){
            var count = [];
            for(var i=0;i<data.print.length;i++){
                count.push({
                    value:data.print[i],
                    itemStyle:{
                        normal:{
                            color:'#C8B2F4'

                        }
                    }
                });
            }
            var getprinttimesAmountBy_year = echarts.init(document.getElementById('getprinttimesAmountBy_year'));
            var getprinttimesAmountBy_yearoption = {
                animation:false,
                backgroundColor:'white',
                xAxis: [
                    {
                        name:'年',
                        type: 'category',
                        show:true,
                        data: data.year,
                        axisPointer: {
                            type: 'shadow'
                        },
                        axisTick: {
                            show: false
                        },
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        name: '打印页数',
                        /*min: 0,
                         max:100,
                         interval: 20,*/
                        axisLabel: {
                            formatter: '{value}'
                        },
                        axisTick: {
                            show: false
                        }
                    },

                ],
                grid:{
                    left:'12%',
                    right:'10%',
                    bottom:'10%'
                },
                series: [
                    {
                        /*name:'保障率',*/
                        type:'bar',
                        barWidth: '30%',
                        data:count,
                        label: {
                            normal: {
                                show: true,
                                position: 'top',
                                formatter: '{c}'
                            }
                        },
                    },

                    {
                        type:'line',
                        name:'占比',
                        data:data.print
                    }
                ],
            };
            getprinttimesAmountBy_year.setOption(getprinttimesAmountBy_yearoption);
        }
    });
}
function getcopytimesAmountBy_year() {
    $.ajax({
        type:'get',
        url:'../../schoolReport/gettypeprintsamount',
        contentType: 'application/json',
        async:false,
        dataType: 'json',
        success: function(data, textStatus, jqXHR){
            var count = [];
            for(var i=0;i<data.copy.length;i++){
                count.push({
                    value:data.copy[i],
                    itemStyle:{
                        normal:{
                            color:'#32DADD'

                        }
                    }
                });
            }
            var getcopytimesAmountBy_year = echarts.init(document.getElementById('getcopytimesAmountBy_year'));
            var getcopytimesAmountBy_yearoption = {
                backgroundColor:'white',
                animation:false,
                xAxis: [
                    {
                        name:'年',
                        type: 'category',
                        show:true,
                        data: data.year,
                        axisPointer: {
                            type: 'shadow'
                        },
                        axisTick: {
                            show: false
                        },
                    }
                ],

                yAxis: [
                    {
                        type: 'value',
                        name: '复印页数',
                        /*min: 0,
                         max:100,
                         interval: 20,*/
                        axisLabel: {
                            formatter: '{value}'
                        },
                        axisTick: {
                            show: false
                        }
                    },

                ],
                series: [
                    {
                        /*name:'保障率',*/
                        type:'bar',
                        barWidth: '30%',
                        data:count,
                        label: {
                            normal: {
                                show: true,
                                position: 'top',
                                formatter: '{c}'
                            }
                        },
                    },

                    {
                        type:'line',
                        name:'占比',
                        data:data.copy
                    }
                ],
            };
            getcopytimesAmountBy_year.setOption(getcopytimesAmountBy_yearoption);
        }
    });
}
function getscantimesAmountBy_year() {
    $.ajax({
        type:'get',
        url:'../../schoolReport/gettypeprintsamount',
        contentType: 'application/json',
        async:false,
        dataType: 'json',
        success: function(data, textStatus, jqXHR){
            var count = [];
            for(var i=0;i<data.scan.length;i++){
                count.push({
                    value:data.scan[i],
                    itemStyle:{
                        normal:{
                            color:'#FF3292'

                        }
                    }
                });
            }
            var getscantimesAmountBy_year = echarts.init(document.getElementById('getscantimesAmountBy_year'));
            var getscantimesAmountBy_yearoption = {
                animation:false,
                backgroundColor:'white',
                xAxis: [
                    {
                        name:'年',
                        type: 'category',
                        show:true,
                        data: data.year,
                        axisPointer: {
                            type: 'shadow'
                        },
                        axisTick: {
                            show: false
                        },
                    }
                ],

                yAxis: [
                    {
                        type: 'value',
                        name: '扫描页数',
                        /*min: 0,
                         max:100,
                         interval: 20,*/
                        axisLabel: {
                            formatter: '{value}'
                        },
                        axisTick: {
                            show: false
                        }
                    },

                ],
                series: [
                    {
                        /*name:'保障率',*/
                        type:'bar',
                        barWidth: '30%',
                        data:count,
                        label: {
                            normal: {
                                show: true,
                                position: 'top',
                                formatter: '{c}'
                            }
                        },
                    },

                    {
                        type:'line',
                        name:'占比',
                        data:data.scan
                    }
                ],
            };
            getscantimesAmountBy_year.setOption(getscantimesAmountBy_yearoption);
        }
    });
}
function getprints_hour() {
    $.ajax({
        type:'get',
        contentType:'application/json',
        url:'../../schoolReport/getDeviceCount_Byhour',
        dataType:'json',
        async:false,
        success:function (data) {
            var printshour = [];
            var printshourtimes = [];
            for(var i=0;i<data.length;i++){
                printshour.push(data[i].hour);
                printshourtimes.push(data[i].prints);
            }
            var max_prints = Math.max.apply(Math,printshourtimes);
            var prints_hour =printshour[printshourtimes.indexOf(max_prints)];//自助文印设备的高峰期 lend_hour点-lend_hour+1点
            $(".print-info").find(".max-hour").text(prints_hour);
            $(".print-info").find(".next-hour").text(parseInt(prints_hour) + 1);
            replace["print_day_clock1"] = prints_hour+"点";
            replace["print_day_clock2"] = parseInt(prints_hour) + 1+"点";
            var getprints_hour = echarts.init(document.getElementById('getprints_hour'));
            var getprints_houroption = {
                animation:false,
                backgroundColor:'white',
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    top:'5%',
                    data: ['自助文印次数']
                },
                grid: {
                    left: '2%',
                    right: '5%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis: {
                    type: 'category',
                    boundaryGap: false,
                    data: printshour,
                    splitLine: { //设置X轴的网格
                        show: true,
                        interval: 'auto'
                    },
                    axisLine: { //设置X轴的颜色
                        lineStyle: {
                            color: 'blue'
                        }
                    }
                },
                yAxis: {
                    type: 'value',
                    axisLine: { //设置y轴的颜色
                        lineStyle: {
                            color: 'blue'
                        }
                    }
                },
                series: [{
                    name: '自助文印次数',
                    type: 'line',
                    stack: '总量',
                    smooth: true, //点与点之间的幅度,false为直线
                    // symbol: 'circle',
                    // symbolSize: 5,
                    // showSymbol: true,   //是否显示点数据的圆点
                    // itemStyle: {    //设置折线的border颜色
                    //     normal: {
                    //         color: 'rgb(0,136,212)',
                    //         borderColor: 'rgba(0,136,212,0.2)',
                    //         borderWidth: 10
                    //     }
                    // },
                    label: { //设置点数据的提示
                        normal: {
                            show: true,
                            position: 'top'
                        }
                    },
                    data: printshourtimes,
                    markPoint: { //设置最大值和最小值
                        data: [{
                            type: 'max',
                            name: '最大值'
                        }, {
                            type: 'min',
                            name: '最小值'
                        }]
                    }

                }]
            };
            getprints_hour.setOption(getprints_houroption);
        }
    })
}
function readerLend() {
    $.get('../../schoolReport/getReder_booklendCount_Byyear',function (info) {
        //console.log(info)
        $(".reader-info").find(".max-name").text(info[0].name);
        $(".reader-info").find(".sec-name").text(info[1].name);
        $(".reader-info").find(".third-name").text(info[2].name);
        $(".reader-info").find(".max-num").text(info[0].all_lend_times);
        $(".reader-info").find(".sec-num").text(info[1].all_lend_times);
        $(".reader-info").find(".third-num").text(info[2].all_lend_times);
        replace["lend_reader_year1"] = nowyear;
        replace["lend_reader_name1"] = info[0].name;
        replace["lend_reader_name2"] = info[1].name;
        replace["lend_reader_name3"] = info[2].name;
        replace["lend_reader_times1"] = info[0].all_lend_times;
        replace["lend_reader_times2"] = info[1].all_lend_times;
        replace["lend_reader_times3"] = info[2].all_lend_times;
        replace["form_top10_year"] = nowyear;
        for(var i=0;i<info.length;i++){
            replace["1-"+(i+1)+"-1"] = info[i].account;
            replace["1-"+(i+1)+"-2"] = info[i].name;
            replace["1-"+(i+1)+"-3"] = info[i].academy;
            replace["1-"+(i+1)+"-4"] = info[i].all_lend_times;
        }
        var html = template('readerLend',{param:info});
        $(".reader-lend").html(html);
    })
}
function bookLend1() {
    $.get('../../schoolReport/getop20authorBy_year',function (info) {
        $(".book-info").find(".max-name").text(info[0].book_name);
        $(".book-info").find(".max-num").text(info[0].lend_times);
        replace["top_book_name"] = info[0].book_name;
        replace["top_book_times"] = info[0].lend_times;
        replace["form_numbertop15_year"] = info[0].year;
        var item = cutArray(info);
        var html = template('bookLend1',{param:item});
        for(var i=0;i<item.length;i++){
            replace["2-"+(i+1)+"-1"] = item[i].book_name;
            replace["2-"+(i+1)+"-2"] = item[i].author;
            replace["2-"+(i+1)+"-3"] = item[i].book_pubyear;
            replace["2-"+(i+1)+"-4"] = item[i].lend_times;
        }
        $(".book-lend1").html(html);
    })
}
function bookLend2() {
    $.get('../../schoolReport/getop20bookBy_year',function (info) {
        $(".book-info2").find(".max-name").text(info[0].book_name);
        replace["fav_book_name"] = info[0].book_name;
        replace["fav_book_author"] = info[0].author;
        replace["form_typetop15_year"] = info[0].year;
        var item = cutArray(info);
        var html = template('bookLend2',{param:item});
        for(var i=0;i<item.length;i++){
            replace["3-"+(i+1)+"-1"] = item[i].book_name;
            replace["3-"+(i+1)+"-2"] = item[i].author;
            replace["3-"+(i+1)+"-3"] = item[i].book_pubyear;
            replace["3-"+(i+1)+"-4"] = item[i].lend_times;
        }
        $(".book-lend2").html(html);
    })
}

function bookLend3() {
    $.get('../../schoolReport/getSingleBookLendTop100',function (info) {
        var data = [];
        for(var i = 0; i <info.bookName.length; i++){
           var basedata = new Object();
           basedata.index = i+1;
            basedata.publisher = info.publisher[i];
            basedata.times = info.bookLendTimes[i];
            basedata.bookAuthor = info.bookAuthor[i];
            basedata.bookName = info.bookName[i];
           data.push(basedata);
        }
        replace.top100 = data;
        var html = template('bookLend3',{param:data});
        $(".book-lend3").html(html);
    })
}
// 以下小章代码
function yearUnderGraduatBookLendTop10() {
    $.get('../../schoolReport/getLibraryReportGeneralRankingTop10InUndergraduate',function (info) {
        var data = [];
        for(var i = 0; i <info.length; i++){
            var basedata = new Object();
            basedata.index = i+1;
            basedata.publisher = info[i].book_publisher;
            basedata.times = info[i].book_lend_times;
            basedata.bookAuthor = info[i].book_author;
            basedata.bookName = info[i].book_name;
            data.push(basedata);
        }
        var data1 = [];
        for(var i = 0; i <info.length; i++){
            var basedata = new Object();
            basedata.index = i+1;
            basedata.book_publisher = info[i].book_publisher;
            basedata.book_lend_times = info[i].book_lend_times;
            basedata.book_author = info[i].book_author;
            basedata.book_name = info[i].book_name;
            data1.push(basedata);
        }
        replace.yearUnderGraduatBookLendTop10 = data;
        var html = template('bookLendFinalRankUndergraduate',{param:data1});
        $(".yearUnderGraduatBookLendTop10").html(html);
    })
}

function yearLibraryClassifyRankInUndergraduate() {
    $.get('../../schoolReport/getLibraryClassifyRankInUndergraduate',function (data) {
        var replacedata = [];
        for(var key in data){
            if(key.substr(0, 1) == '0') continue;
            $("#45").append("<div style=\"text-align: center\">"+key+"</div><div class=' table "+key.substr(0, 1)+"'></div>");
            // console.log(data[key]);
            var basedata = new Object();
            basedata.rankingtypename = key;
            var html = template('bookLendFinalRankUndergraduate',{param:data[key]});
            $("."+ key.substr(0, 1)).html(html);
            var chartdata = new Array();
            for(var i = 0; i < data[key].length; i++){
                var chartbasedata = new Object();
                chartbasedata.index = i+1;
                chartbasedata.publisher = data[key][i].book_publisher;
                chartbasedata.times = data[key][i].book_lend_times;
                chartbasedata.bookAuthor = data[key][i].book_author;
                chartbasedata.bookName = data[key][i].book_name;
                chartdata.push(chartbasedata);
            }
            basedata["LibraryClassifyRankInUndergraduate"] = chartdata;
            replacedata.push(basedata);
        }
        replace["getLibraryClassifyRankInUndergraduate"] = replacedata;
    });
}
function yearLibraryClassifyRankInGraduate() {
    $.get('../../schoolReport/getLibraryClassifyRankInGraduate',function (data) {
        var replacedata = [];
        for(var key in data){
            var classKey;
            classKey = key.substr(0, 1) + "yan";
             // console.log(classKey);
            if(classKey.substr(0, 1) == '0') continue;
            $("#47").append("<div style=\"text-align: center\">"+key+"</div><div class=' table "+classKey+"'></div>");
            var basedata = new Object();
            basedata.rankingtypename = key;
            var html = template('bookLendFinalRankUndergraduate',{param:data[key]});
            $("."+ classKey).html(html);
            var chartdata = new Array();
            for(var i = 0; i < data[key].length; i++){
                var chartbasedata = new Object();
                chartbasedata.index = i+1;
                chartbasedata.publisher = data[key][i].book_publisher;
                chartbasedata.times = data[key][i].book_lend_times;
                chartbasedata.bookAuthor = data[key][i].book_author;
                chartbasedata.bookName = data[key][i].book_name;
                chartdata.push(chartbasedata);
            }
            basedata["LibraryClassifyRankInUndergraduate"] = chartdata;
            replacedata.push(basedata);
        }
        replace["getLibraryClassifyRankInGraduate"] = replacedata;
    });
}
// 以上小章代码

function bookLendFinalRankTop10InGraduate() {
    $.get('../../schoolReport/getLibraryReportGeneralRankingTop10InGraduate',function (info1) {
        var data2 = [];
        for(var i = 0; i <info1.length; i++){
            var basedata = new Object();
            basedata.index = i+1;
            basedata.publisher = info1[i].book_publisher;
            basedata.times = info1[i].book_lend_times;
            basedata.bookAuthor = info1[i].book_author;
            basedata.bookName = info1[i].book_name;
            data2.push(basedata);
        }
        var data3 = [];
        for(var i = 0; i <info1.length; i++){
            var basedata = new Object();
            basedata.index = i+1;
            basedata.book_publisher = info1[i].book_publisher;
            basedata.book_lend_times = info1[i].book_lend_times;
            basedata.book_author = info1[i].book_author;
            basedata.book_name = info1[i].book_name;
            data3.push(basedata);
        }
        replace.yearGraduatBookLendTop10 = data2;
        var html = template('bookLendFinalRankUndergraduate',{param:data3});
        $(".yearGraduatBookLendTop10").html(html);
    })
}

function staffLend() {
    $.get('../../schoolReport/getTeacherCount_BycountAndyear',function (info) {
        var item ={
            year:[],
            // data:[
            //     {name:'<10册',data1:info['<10册'][0].lend,data2:info['<10册'][1].lend,data3:info['<10册'][2].lend},
            //     {name:'11-20册',data1:info['11-20册'][0].lend,data2:info['11-20册'][1].lend,data3:info['11-20册'][2].lend},
            //     {name:'21-30册',data1:info['21-30册'][0].lend,data2:info['21-30册'][1].lend,data3:info['21-30册'][2].lend},
            //     {name:'31-50册',data1:info['31-50册'][0].lend,data2:info['31-50册'][1].lend,data3:info['31-50册'][2].lend},
            //     {name:'51-100册',data1:info['51-100册'][0].lend,data2:info['51-100册'][1].lend,data3:info['51-100册'][2].lend},
            //     {name:'101-200册',data1:info['101-200册'][0].lend,data2:info['101-200册'][1].lend,data3:info['101-200册'][2].lend},
            //     {name:'201-300册',data1:info['201-300册'][0].lend,data2:info['201-300册'][1].lend,data3:info['201-300册'][2].lend},
            //     {name:'>300册',data1:info['>300册'][0].lend,data2:info['>300册'][1].lend,data3:info['>300册'][2].lend}
            // ],
            dat:[]
        };
        getArray(info,item.dat,'<10册');
        getArray(info,item.dat,'11-20册');
        getArray(info,item.dat,'21-30册');
        getArray(info,item.dat,'31-50册');
        getArray(info,item.dat,'31-50册');
        getArray(info,item.dat,'51-100册');
        getArray(info,item.dat,'101-200册');
        getArray(info,item.dat,'201-300册');
        getArray(info,item.dat,'>300册');
        for(var i=0;i<info['11-20册'].length;i++){
            item.year.push(info['11-20册'][i].year);
        }
        var html = template('staffLend',{param:item});
       // console.log(2);
       // console.log(item);
        for(var i=1;i<=item.dat.length;i++){
            replace["4-"+i+"-1"] = item.dat[i-1].data1;
            replace["4-"+i+"-2"] = item.dat[i-1].data2;
            replace["4-"+i+"-3"] = item.dat[i-1].data3;
        }
        replace["chart_year1"] = item.year[0];
        replace["chart_year2"] = item.year[1];
        replace["chart_year3"] = item.year[2];
        $(".staff-lend").html(html);
    })
}
function cutArray(array) {
    var data=[];
    for(var i=0;i<15;i++){
        data.push(array[i]);
    }
    return data;
}
function getArray(info,data,txt) {
    if(info[txt].length==3){
        data.push({name:txt,data1:info[txt][0].lend,data2:info[txt][1].lend,data3:info[txt][2].lend})
    }
    return data;
}
function Max(arr){
    var obj = {
        p:0,
        num:arr[0]
    };
    for(var i=0;i<arr.length;i++){
        if(obj.num < arr[i]){
            obj.num = arr[i];
            obj.p = i;
        }
    }
    return obj;
}
function Sum(arr) {
    var s = 0;
    for (var i=arr.length-1; i>=0; i--) {
        s += arr[i];
    }
    return s;
}
function sortByKey(array,key){
    return array.sort(function(a,b){
        var x=a[key];
        var y=b[key];
        return ((x<y)?-1:((x>y)?1:0));
    });
}



function getCollectionOverall(){
    var dataAll=[];
    var yAxisData=[];
    var piedata=[];
    $.ajax({
        type:'get',
        url:'../../schoolReport/getCollectionOverall',
        contentType: 'application/json',
        async:false,
        dataType: 'json',
        success: function(data, textStatus, jqXHR){
            var html = template('getCollectionOveralltable',{param:data.object});
            $(".getCollectionOveralltable").html(html);
            for(var i=0;i<data.object.length;i++){
                replace["13-"+(i+1)+"-1"] = data.object[i].stack;
                replace["13-"+(i+1)+"-2"] = data.object[i].amount;
            }
            dataAll=data.amount;
            yAxisData=data.stack;
            for(var i=0;i<dataAll.length;i++){
                // console.log({ value:dataAll[i],name:yAxisData[i]})
                piedata.push({ value:dataAll[i],name:yAxisData[i]});
            }
            //  console.log(piedata)
            var getCollectionOverall = echarts.init(document.getElementById('getCollectionOverall'));
            var getCollectionOveralloption = {
                animation:false,
                backgroundColor: '#0f375f',
                title:[
                    {text:"各馆藏书占比",x: '2%', y: '1%',textStyle:{color:"#fff",fontSize:"14"}},
                    {text:"各馆藏书TOP10",x: '40%', y: '1%',textStyle:{color:"#fff",fontSize:"14"}},

                ],
                grid: [
                    {x: '65%', y: '7%', width: '30%', height: '90%'},
                ],
                tooltip: {
                    formatter: '{b} ({c})'
                },
                xAxis: [
                    {gridIndex: 0, axisTick: {show:false},axisLabel: {show:false},splitLine: {show:false},axisLine: {show:false }},
                ],
                yAxis: [
                    {  gridIndex: 0, interval:0,data:yAxisData,
                        axisTick: {show:false}, axisLabel: {show:true},splitLine: {show:false},
                        axisLine: {show:true,lineStyle:{color:"#6173a3"}},
                    }
                ],
                series: [
                    {
                        name: '各馆藏书占比',
                        type: 'pie',
                         radius : '30%',
                        center: ['25%', '50%'],
                        color:['#86c9f4','#4da8ec','#3a91d2','#005fa6','#315f97'],
                        data:piedata,
                        label:{normal:{show:true,position:'outside',fontSize:12}},
                        labelLine:{normal:{show:true} },
                        itemStyle: {normal: {label:{ show: true,  formatter: '({d}%)', textStyle:{color:'#B1B9D3'}} },},
                    },

                    {
                        name: '各馆藏书TOP10',
                        type: 'bar',xAxisIndex: 0,yAxisIndex: 0,barWidth:'45%',
                        itemStyle:{normal:{color:'#86c9f4'}},
                        label:{normal:{show:true, position:"right",textStyle:{color:"#9EA7C4"}}},
                        data: dataAll,
                    },

                ]
            };
            getCollectionOverall.setOption(getCollectionOveralloption);
        }
    });


}

function getCollectionNewAdded(){
    var dataAll=[];
    var yAxisData=[];
    var piedata=[];
    $.ajax({
        type:'get',
        url:'../../schoolReport/getCollectionNewAdded',
        contentType: 'application/json',
        async:false,
        dataType: 'json',
        success: function(data, textStatus, jqXHR){
            var html = template('getCollectionOveralltable',{param:data.object});
            $(".getCollectionNewAddedtable").html(html);
            for(var i=0;i<data.object.length;i++){
                replace["10-"+(i+1)+"-1"] = data.object[i].stack;
                replace["10-"+(i+1)+"-2"] = data.object[i].amount;
            }
            dataAll=data.amount;
            yAxisData=data.stack;
            for(var i=0;i<dataAll.length;i++){
                // console.log({ value:dataAll[i],name:yAxisData[i]})
                piedata.push({ value:dataAll[i],name:yAxisData[i]});
            }
            //  console.log(piedata)
            var getCollectionNewAdded = echarts.init(document.getElementById('getCollectionNewAdded'));
            var getCollectionNewAddedoption = {
                animation:false,
                backgroundColor: '#0f375f',
                title:[
                    {text:"各馆新增藏书占比",x: '2%', y: '1%',textStyle:{color:"#fff",fontSize:"14"}},
                    {text:"各馆新增藏书TOP10",x: '40%', y: '1%',textStyle:{color:"#fff",fontSize:"14"}},

                ],
                grid: [
                    {x: '65%', y: '7%', width: '30%', height: '90%'},
                ],
                tooltip: {
                    formatter: '{b} ({c})'
                },
                xAxis: [
                    {gridIndex: 0, axisTick: {show:false},axisLabel: {show:false},splitLine: {show:false},axisLine: {show:false }},
                ],
                yAxis: [
                    {  gridIndex: 0, interval:0,data:yAxisData,
                        axisTick: {show:false}, axisLabel: {show:true},splitLine: {show:false},
                        axisLine: {show:true,lineStyle:{color:"#6173a3"}},
                    }
                ],
                series: [
                    {
                        name: '各馆新增藏书占比',
                        type: 'pie',
                        radius : '30%',
                        center: ['25%', '50%'],
                        color:['#86c9f4','#4da8ec','#3a91d2','#005fa6','#315f97'],
                        data:piedata,
                        label:{normal:{show:true,position:'outside',fontSize:12}},
                        labelLine:{normal:{show:true} },
                        itemStyle: {normal: {label:{ show: true,  formatter: '({d}%)', textStyle:{color:'#B1B9D3'}} },},
                    },

                    {
                        name: '各馆新增藏书TOP10',
                        type: 'bar',xAxisIndex: 0,yAxisIndex: 0,barWidth:'45%',
                        itemStyle:{normal:{color:'#86c9f4'}},
                        label:{normal:{show:true, position:"right",textStyle:{color:"#9EA7C4"}}},
                        data: dataAll,
                    },

                ]
            };
            getCollectionNewAdded.setOption(getCollectionNewAddedoption);
        }
    });


}

function getCollectionNewAddedByCate(){
    var booktype=[];
    var category=[];
    var servicedata=[];
    $.ajax({
        type:'get',
        url:'../../schoolReport/getCollectionNewAddedByCate',
        contentType: 'application/json',
        async:false,
        dataType: 'json',
        success: function(data, textStatus, jqXHR){
            var params={};
            var obs=[];
            params.booktype=data.booktype
            for(var i=0;i<data.category.length;i++){
                var ob={};ob["category"]=data.category[i];
                replace["11-"+(i+2)+"-1"] = data.category[i];
                for(var j=0;j<data.booktype.length;j++) {
                    var bt=data.booktype[j];
                    replace["11-1-"+(j+2)] = data.booktype[j];
                    replace["11-"+(i+2)+"-"+(j+2)] = data.values[0][data.booktype[j]][i];
                    ob[bt]=data.values[0][data.booktype[j]][i];
                }
                obs.push(ob)
            }
            params.obs=obs;
            params.keys=["category"].concat(data.booktype)

            var html = template('getCollectionNewAddedByCatetable',{param:params});
            $(".getCollectionNewAddedByCatetable").html(html);

            booktype=data.booktype;
            category=data.category;
            for(var key in data){
                if(key=="values")
                {
                    var value=data.values;
                    for(var b1=0;b1<booktype.length;b1++){
                        var bt=booktype[b1];
                        servicedata.push({ name:booktype[b1] ,type: 'bar',data:value[0][booktype[b1]]});
                    }

                }
            }

            var getCollectionNewAddedByCate = echarts.init(document.getElementById('getCollectionNewAddedByCate'));
            var getCollectionNewAddedByCateoption = {
                animation:false,
                tooltip: {
                    trigger: 'axis',
                    axisPointer: { // 坐标轴指示器，坐标轴触发有效
                        type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                legend: {
                    data:booktype,
                    align: 'right',
                    right: 10
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis: [{
                    type: 'category',
                    data: category
                }],
                yAxis: [{
                    type: 'value',
                    name: '总数(本)',
                    axisLabel: {
                        formatter: '{value}'
                    }
                }],
                series: servicedata
            };
            getCollectionNewAddedByCate.setOption(getCollectionNewAddedByCateoption);
        }
    });


}

function getCollectionTuShuNewAddedByCate(){
    var booktype=[];
    var category=[];
    var servicedata=[];
    $.ajax({
        type:'get',
        url:'../../schoolReport/getCollectionTuShuNewAddedByCate',
        contentType: 'application/json',
        async:false,
        dataType: 'json',
        success: function(data, textStatus, jqXHR){
            var params={};
            var obs=[];
            params.booktype=data.booktype
            for(var i=0;i<data.category.length;i++){
                var ob={};ob["category"]=data.category[i];
                replace["12-"+(i+2)+"-1"] = data.category[i];
                for(var j=0;j<data.booktype.length;j++) {
                    var bt=data.booktype[j];
                    replace["12-1-"+(j+2)] = data.booktype[j];
                    replace["12-"+(i+2)+"-"+(j+2)] = data.values[0][data.booktype[j]][i];
                    ob[bt]=data.values[0][data.booktype[j]][i];
                }
                obs.push(ob)
            }
            params.obs=obs;
            params.keys=["category"].concat(data.booktype)

            var html = template('getCollectionNewAddedByCatetable',{param:params});
            $(".getCollectionTuShuNewAddedByCatetable").html(html);

            booktype=data.booktype;
            category=data.category;
            for(var key in data){
                if(key=="values")
                {
                    var value=data.values;
                    for(var b1=0;b1<booktype.length;b1++){
                        var bt=booktype[b1];
                        servicedata.push({ name:booktype[b1] ,type: 'bar',data:value[0][booktype[b1]]});
                    }

                }
            }
            var getCollectionTuShuNewAddedByCate = echarts.init(document.getElementById('getCollectionTuShuNewAddedByCate'));
            var getCollectionTuShuNewAddedByCateoption = {
                animation:false,
                tooltip: {
                    trigger: 'axis',
                    axisPointer: { // 坐标轴指示器，坐标轴触发有效
                        type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                legend: {
                    data:booktype,
                    align: 'right',
                    right: 10
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis: [{
                    type: 'category',
                    data: category
                }],
                yAxis: [{
                    type: 'value',
                    name: '总数(本)',
                    axisLabel: {
                        formatter: '{value}'
                    }
                }],
                series: servicedata
            };
            getCollectionTuShuNewAddedByCate.setOption(getCollectionTuShuNewAddedByCateoption);
        }
    });


}

function getCollectionWaiWenNewAddedByCate(){
    var lengthdata=[];
    var servicedata=[];
    $.ajax({
        type:'get',
        url:'../../schoolReport/getCollectionWaiWenNewAddedByCate',
        contentType: 'application/json',
        async:false,
        dataType: 'json',
        success: function(data, textStatus, jqXHR){
            //var html = template('getCollectionTuShuNewAddedByCatetable',{param:data.ob});
            //$(".getCollectionTuShuNewAddedByCatetable").html(html)
            lengthdata=data.category;

            var center1= ['10%', '30%'];
            var center2= ['30%', '30%'];
            var center3=['50%', '30%'];
            var center4= ['70%', '30%'];
            var center5= ['90%', '30%'];
            var center6=['10%', '70%'];
            var center7= ['30%', '70%'];
            var center8=['50%', '70%'];
            var center9= ['70%', '70%'];
            var center10=['90%', '70%'];
            var centers=[center1,center2,center3,center4,center5,center6,center7,center8,center9,center10];i
            var labelTop = {
                normal : {
                    label : {
                        show : true,
                        position : 'center',
                        formatter : '{b}',
                        textStyle: {
                            baseline : 'bottom'
                        }
                    },
                    labelLine : {
                        show : false
                    }
                }
            };
            var labelFromatter = {
                normal : {
                    label : {
                        formatter : function (params){
                            return  ((data['count'][0] - params.value)/data['count'][0]).toFixed(2)
                        },
                        textStyle: {
                            baseline : 'top'
                        }
                    }
                },
            }
            var labelBottom = {
                normal : {
                    color: '#ccc',
                    label : {
                        show : true,
                        position : 'center'
                    },
                    labelLine : {
                        show : false
                    }
                },
                emphasis: {
                    color: 'rgba(0,0,0,0)'
                }
            };
            var radius = [40, 55];
            for(var i=0;i<data["category"].length;i++){
                servicedata.push(
                    {
                        type : 'pie',
                        center : centers[i],
                        radius : radius,
                        itemStyle : labelFromatter,
                        data : [
                            {name:'other', value:data['count'][0]-data['外文图书'][i], itemStyle : labelBottom},
                            {name:data['category'][i], value:data['外文图书'][i],itemStyle : labelTop}
                        ]
                    }
                );
            }
            var getCollectionWaiWenNewAddedByCateoption = {
                animation:false,
                legend: {
                    x : 'center',
                    y : 'center',
                    data:lengthdata
                },
                /* toolbox: {
                 show : true,
                 feature : {
                 dataView : {show: true, readOnly: false},
                 magicType : {
                 show: true,
                 type: ['pie', 'funnel'],
                 option: {
                 funnel: {
                 width: '20%',
                 height: '30%',
                 itemStyle : {
                 normal : {
                 label : {
                 formatter : function (params){
                 return 'other\n' + params.value + '%\n'
                 },
                 textStyle: {
                 baseline : 'middle'
                 }
                 }
                 },
                 }
                 }
                 }
                 },
                 restore : {show: true},
                 saveAsImage : {show: true}
                 }
                 },*/
                series : servicedata
            };
            var getCollectionWaiWenNewAddedByCate = echarts.init(document.getElementById('getCollectionWaiWenNewAddedByCate'));
            getCollectionWaiWenNewAddedByCate.setOption(getCollectionWaiWenNewAddedByCateoption);
        }
    });


}

function getCollectionAmountType() {
    $.ajax({
        type:'get',
        url:'../../schoolReport/getCollectionAmountType?'+nowyear,
        contentType:'application/json',
        async:false,
        dataType:'json',
        success:function (data){
            var param = [];
            var amount1 = 0;
            var amount2 = 0;
            var amount3 = 0;
            var chartdata = [];
            for(var i=0;i<data.stack.length;i++){
                var basedata = new Object();
                var basechartdata = new Object();
                basedata.stack=data.stack[i];
                basechartdata["5-1-1"]=data.stack[i];
                basedata.amounttype=data.amounttype[i];
                basechartdata["5-1-2"]=data.amounttype[i];
                if(data.stackpubyear.indexOf(data.stack[i])!=-1){
                    basedata.amounttypePubyear = data.amounttypePubyear[data.stackpubyear.indexOf(data.stack[i])];
                    basechartdata["5-1-4"] = data.amounttypePubyear[data.stackpubyear.indexOf(data.stack[i])];
                }
                else{
                    basedata.amounttypePubyear=0;
                    basechartdata["5-1-4"]=0;
                }
                if(data.stackthisyear.indexOf(data.stack[i])!=-1){
                    basedata.amounttypeYear = data.amounttypeYear[data.stackthisyear.indexOf(data.stack[i])];
                    basechartdata["5-1-3"] = data.amounttypeYear[data.stackthisyear.indexOf(data.stack[i])];
                }
                else{
                    basedata.amounttypeYear=0;
                    basechartdata["5-1-3"]=0;
                }
                amount1+=basedata.amounttype;
                amount3+=basedata.amounttypePubyear;
                amount2+=basedata.amounttypeYear;
                param.push(basedata);
                chartdata.push(basechartdata);
            }
            var html = template('getCollectionAmountType',{param:param,amount1:amount1,amount2:amount2,amount3:amount3});
            var amountchart = new Object();
            amountchart["5-1-1"] = "总计";
            amountchart["5-1-2"] = amount1;
            amountchart["5-1-3"] = amount2;
            amountchart["5-1-4"] = amount3;
            chartdata.push(amountchart);
            replace["book_collection_amount_chart"] = chartdata;
            $(".getCollectionAmountTypeTable").html(html);
            $(".collectionyear").text(nowyear);
            $(".amount1").text(amount1);
            $(".amount2").text(amount2);
            $(".amount3").text(amount3);
            replace["collection-year"] = nowyear;
            replace["collection-amount-type"] = amount1;
            replace["collection-amount-add"] = amount2;
            replace["collection-amount-pub"] = amount3;

        }
    })
}

function getCollectionByStackAndBooktype() {
    $.ajax({
        type:'get',
        url:'../../schoolReport/getCollectionByStackAndBooktype',
        contentType:'application/json',
        async:false,
        dataType:'json',
        success:function (data){
            var param = [];
            var chartdata = [];
            for(var i=0;i<data.stack.length;i++){
                var chartbase = new Object();
                var basedata = new Object();
                basedata.stack = data.stack[i];
                chartbase["6-2-1"] = data.stack[i];
                var arr = new Array;
                var amount=0;
                for(var j=0;j<data.bookType.length;j++){
                    arr.push(data.amounttype[i*data.bookType.length+j]);
                    chartbase["6-2-"+(j+2)] = data.amounttype[i*data.bookType.length+j];
                    amount+=data.amounttype[i*data.bookType.length+j];
                }
                basedata.amounttype = arr;
                basedata.amount=amount;
                chartbase["6-2-"+(data.bookType.length+2)] = amount;
                chartdata.push(chartbase);
                param.push(basedata);
            }
            var arr1 = [];
            for(var i=0;i<param.length;i++){
                for(var j=0;j<param[i].amounttype.length;j++){
                    if(i==0){
                        arr1[j] = param[i].amounttype[j];
                    }
                    else{
                        arr1[j]+=param[i].amounttype[j];
                    }
                }
                if(i==0){
                    arr1[param[i].amounttype.length] = param[i].amount;
                }
                else{
                    arr1[param[i].amounttype.length] += param[i].amount;
                }
            }
            var chartamount = new Object();
            chartamount["6-2-1"] = "合计";
            for(var i = 0;i<data.bookType.length;i++){
                replace["6-1"+"-"+(i+2)] = data.bookType[i];
            }
            for(var i=0;i<arr1.length;i++){
                chartamount["6-2-"+(i+2)] = arr1[i];
            }
            chartdata.push(chartamount);
            //console.log(chartdata);
            replace.category_stack_amount = chartdata;
            var html = template('getCollectionByStackAndBooktype',{param:param,bookType:data.bookType,arr1:arr1});
            $(".getCollectionByStackAndBooktype").html(html);
        }
    })
}

function getCollectionByPubyear() {
    $.ajax({
        type:'get',
        url:'../../schoolReport/getCollectionByPubyear',
        contentType:'application/json',
        async:false,
        dataType:'json',
        success:function (data){
            var param = [];
            var typechart=[];
            var numberchart=[];
            var yeardata = [];
            var amounttype = 0;
            var amountnumber = 0;
            for(var key in data){
                var basedata = new Object();
                var typechartdata = new Object();
                var numberchartdata = new Object();
                var index = 0;
                switch(key){
                    case "-1919" : index=0;break;
                    case "1920-1929" : index=1;break;
                    case "1930-1939" : index=2;break;
                    case "1940-1949" : index=3;break;
                    case "1950-1959" : index=4;break;
                    case "1960-1969" : index=5;break;
                    case "1970-1979" : index=6;break;
                    case "1980-1989" : index=7;break;
                    case "1990-1999" : index=8;break;
                    case "2000-2009" : index=9;break;
                    case "2010-" : index=10;break;
                    case "不详" : index=11;break;
                }
                basedata.year = key;
                basedata.amounttype = data[key].amounttype;
                basedata.amountnumber = data[key].amountnumber;
                amounttype += data[key].amounttype;
                amountnumber += data[key].amountnumber;
                param[index] = basedata;
                yeardata[index] = key;
                typechartdata.name = key;
                typechartdata.value = data[key].amounttype;
                typechart[index] = typechartdata;
                numberchartdata.name = key;
                numberchartdata.value = data[key].amountnumber;
                numberchart[index] = numberchartdata;
            }
            for(var i=0;i<param.length;i++){
                param[i].typepecent = parseFloat(param[i].amounttype/amounttype)*100;
                param[i].numberpecent = parseFloat(param[i].amountnumber/amountnumber)*100;
                param[i].typepecent = param[i].typepecent.toFixed(2)+"%";
                param[i].numberpecent = param[i].numberpecent.toFixed(2)+"%";
                replace["7-"+(i+1)+"-1"] = param[i].amounttype;
                replace["7-"+(i+1)+"-2"] = param[i].typepecent;
                replace["7-"+(i+1)+"-3"] = param[i].amountnumber;
                replace["7-"+(i+1)+"-4"] = param[i].numberpecent;
            }
            replace["7-"+(param.length+1)+"-1"] = amounttype;
            replace["7-"+(param.length+1)+"-3"] = amountnumber;
            var html = template('getCollectionByPubyear',{param:param,amounttype:amounttype,amountnumber:amountnumber});
            $(".getCollectionByPubyear").html(html);
            var typeoption = {
                animation:false,
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b}: {c} ({d}%)",
                },
                legend: {
                    y:'bottom',
                    itemWidth: 14,
                    itemHeight: 14,
                    align: 'left',
                    data:yeardata
                },
                series: [
                    {
                        name:'图书出版年发布（种）',
                        type:'pie',
                        hoverAnimation: false,
                        legendHoverLink:false,
                        radius: ['40%', '42%'],
                        color: ['#CD0000','#FFEC8B','#0000CD','#FF4500','#FF3E96','#d74e67', '#0092ff', '#eba954', '#21b6b9','#60a900','#01949b',' #f17677'],
                        label: {
                            normal: {
                                position: 'inner'
                            }
                        },
                        labelLine: {
                            normal: {
                                show: false
                            },

                        },
                        tooltip: {
                            show:false,


                        },
                    },
                    {
                        name:'图书出版年发布（种）',
                        type:'pie',
                        radius: ['42%', '55%'],
                        color: ['#CD0000','#FFEC8B','#0000CD','#FF4500','#FF3E96','#d74e67', '#0092ff', '#eba954', '#21b6b9','#60a900','#01949b',' #f17677'],
                        label: {
                            normal: {
                                formatter: '{b}\n{d}%'
                            },

                        },
                        data:typechart
                    }
                ]
            };

            var numberoption = {
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b}: {c} ({d}%)",
                },
                legend: {
                    y:'bottom',
                    itemWidth: 14,
                    itemHeight: 14,
                    align: 'left',
                    data:yeardata
                },
                series: [
                    {
                        name:'图书出版年发布（册）',
                        type:'pie',
                        hoverAnimation: false,
                        legendHoverLink:false,
                        radius: ['40%', '42%'],
                        color: ['#CD0000','#FFEC8B','#0000CD','#FF4500','#FF3E96','#d74e67', '#0092ff', '#eba954', '#21b6b9','#60a900','#01949b',' #f17677'],
                        label: {
                            normal: {
                                position: 'inner'
                            }
                        },
                        labelLine: {
                            normal: {
                                show: false
                            },

                        },
                        tooltip: {
                            show:false,
                        },
                    },
                    {
                        name:'图书出版年发布（册）',
                        type:'pie',
                        radius: ['42%', '55%'],
                        color: ['#CD0000','#FFEC8B','#0000CD','#FF4500','#FF3E96','#d74e67', '#0092ff', '#eba954', '#21b6b9','#60a900','#01949b',' #f17677'],
                        label: {
                            normal: {
                                formatter: '{b}\n{d}%'
                            },

                        },
                        data:numberchart
                    }
                ]
            };
            var typechart = echarts.init(document.getElementById("typechart"));
            var typenumber = echarts.init(document.getElementById("typenumber"));
            typechart.setOption(typeoption);
            typenumber.setOption(numberoption);
        }
    });
}

function getCollectionBycategory() {
    $.ajax({
        type:'get',
        url:'../../schoolReport/getCollectionBycategory',
        contentType:'application/json',
        async:false,
        dataType:'json',
        success:function (data){
            var arr = [];
            var arr1 = [];
            var seriestype = [];
            var seriesnumber = [];
            for(var i=0;i<data.bookType.length;i++){
                arr[i] = [];
                arr1[i] = [];
                for(var j=0;j<data.category.length;j++){
                    arr[i].push(data.amounttype[i*data.category.length+j]);
                    arr1[i].push(data.amountnumber[i*data.category.length+j]);
                }
            }
            var itemcolor = ['#FF7F0E','#2CA02C','#6ca7e2','#00CCFF','#915872','#3077b7','#9a8169','#3f8797'];
            for(var i=0;i<arr.length;i++){
                seriestype.push({
                    name: data.bookType[i],
                    type: 'bar',
                    stack: '总量',
                    itemStyle:{
                        normal:{
                            color:itemcolor[i]
                        }
                    },
                    label: {
                        normal: {
                            show: false,
                            position: 'insideRight'
                        }
                    },
                    data: arr[i]
                });
                seriesnumber.push({
                    name: data.bookType[i],
                    type: 'bar',
                    stack: '总量',
                    itemStyle:{
                        normal:{
                            color:itemcolor[i]
                        }
                    },
                    label: {
                        normal: {
                            show: false,
                            position: 'insideRight'
                        }
                    },
                    data: arr1[i]
                });
            }
            var typeoption = {
                animation:false,
                tooltip : {
                    trigger: 'axis',
                    axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                        type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                legend: {
                    data: data.bookType
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis:  {
                    type: 'value'
                },
                yAxis: {
                    type: 'category',
                    data: data.category
                },
                series: seriestype
            };
            var numberoption = {
                animation:false,
                tooltip : {
                    trigger: 'axis',
                    axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                        type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                legend: {
                    data: data.bookType
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis:  {
                    type: 'value'
                },
                yAxis: {
                    type: 'category',
                    data: data.category
                },
                series: seriesnumber
            };
            var typechart = echarts.init(document.getElementById("getCollectionBycategorytype"));
            typechart.setOption(typeoption);
            var numberchart = echarts.init(document.getElementById("getCollectionBycategorynumber"));
            numberchart.setOption(numberoption);
        }
    });
}

function getTop10category(){
    $.ajax({
        type:'get',
        url:'../../schoolReport/getTop10category',
        contentType:'application/json',
        async:false,
        dataType:'json',
        success:function (data){
            var param = [];
            for(var i=0;i<data.category.length;i++){
                replace["8-"+(i+1)+"-1"] = data.category[i];
                replace["8-"+(i+1)+"-2"] = data.amounttype[i];
                param.push({
                    "category" : data.category[i],
                    "amounttype" : data.amounttype[i]
                });
            }
            var html = template('getTop10category',{param:param});
            $(".getTop10category").html(html);
        }
    });
}


//  小章 以下是小章代码

function getBookLendByAcademy() {
    $.ajax({
        type:'get',
        url:'../../schoolReport/getYearTop3CategoryByAcademy',
        contentType:'application/json',
        async:false,
        dataType:'json',
        success:function (data) {
            document.getElementById("ThirdAcademyTitle").innerHTML =data["3"].readerAcademy + "借阅分布";
            replace["img_academy_top3title"] = data["3"].readerAcademy + "借阅分布";
            var getprintsCountBy_year3 = echarts.init(document.getElementById('getBookLendByAcademyThird'));
            var getBookLendByAcademyThird = {
              //  color: ['#000000'],
                tooltip : {
                    trigger: 'axis',
                    axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                        type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                grid: {
                    left: '6%',
                    right: '6%',
                    bottom: '6%',
                    containLabel: true
                },
                xAxis : [
                    {
                        name : '种类',
                        type : 'category',
                        data : data["3"].bookCategory,
                        axisTick: {
                            alignWithLabel: true
                        }
                    }
                ],
                yAxis : [
                    {
                        name : '人次',
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:' 人次',
                        type:'bar',
                        barWidth: '60%',
                        data : data["3"].categoryAmount,
                        itemStyle:{
                            normal:{
                                color:'#3398DB'
                            }
                        },
                        label: {
                            normal: {
                                color: ['#000000'],
                                show: true,
                                position: 'top',
                                formatter: '{c}'
                            }
                        },
                    }
                ]
            };
            getprintsCountBy_year3.setOption(getBookLendByAcademyThird);
            document.getElementById("FirstAcademyTitle").innerHTML =data["1"].readerAcademy + "借阅分布";
            replace["img_academy_top1title"] = data["1"].readerAcademy + "借阅分布";
            var getprintsCountBy_year1 = echarts.init(document.getElementById('getBookLendByAcademyFirst'));
            var getBookLendByAcademyFirst = {
                tooltip : {
                    trigger: 'axis',
                    axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                        type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                grid: {
                    left: '6%',
                    right: '6%',
                    bottom: '6%',
                    containLabel: true
                },
                xAxis : [
                    {
                        name : '种类',
                        type : 'category',
                        data : data["1"].bookCategory,
                        axisTick: {
                            alignWithLabel: true
                        }
                    }
                ],
                yAxis : [
                    {
                        name : '人次',
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:' 人次',
                        type:'bar',
                        barWidth: '60%',
                        data : data["1"].categoryAmount,
                        itemStyle:{
                            normal:{
                                color:'#FFC125'
                            }
                        },
                        label: {
                            normal: {
                                color: ['#000000'],
                                show: true,
                                position: 'top',
                                formatter: '{c}'
                            }
                        },
                    }
                ]
            };
            getprintsCountBy_year1.setOption(getBookLendByAcademyFirst);
            document.getElementById("SecondAcademyTitle").innerHTML =data["2"].readerAcademy + "借阅分布";
            replace["img_academy_top2title"] = data["2"].readerAcademy + "借阅分布";
            var getprintsCountBy_year2 = echarts.init(document.getElementById('getBookLendByAcademySecond'));
            var getBookLendByAcademySecond = {
                tooltip : {
                    trigger: 'axis',
                    axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                        type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                grid: {
                    left: '6%',
                    right: '6%',
                    bottom: '6%',
                    containLabel: true
                },
                xAxis : [
                    {
                        name : '种类',
                        type : 'category',
                        data : data["2"].bookCategory,
                        axisTick: {
                            alignWithLabel: true
                        }
                    }
                ],
                yAxis : [
                    {
                        name : '人次',
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:' 人次',
                        type:'bar',
                        barWidth: '60%',
                        data : data["2"].categoryAmount,
                        itemStyle:{
                            normal:{
                                color:'#9B30FF'
                            }
                        },
                        label: {
                            normal: {
                                color: ['#000000'],
                                show: true,
                                position: 'top',
                                formatter: '{c}'
                            }
                        },
                    }
                ]
            };
            getprintsCountBy_year2.setOption(getBookLendByAcademySecond);
        }
    });

}

function library_report_identity_sum() {
    $.get('../../schoolReport/library_report_identity_sum',function (info) {
        var tabledata = [];
        var barchartdata = [];
        var tablehead = [];
        var ii = 0;
        for(var i = 0; i < info.year.length; i++){
            var basedata1 = [];
            var data = [];
            var sum = 0;
            basedata1.year = info.year[i];
            for(var iii = 0 ; iii < info.identity.length; iii++) {
                var basedata3 = new Object();
                sum += info.sum[ii];
                basedata3.value = info.sum[ii++];
                basedata3.name = info.identity[iii];
                data.push(basedata3);
            }
            basedata1.push(data);
            basedata1.sum = sum; //合计
            tabledata.push(basedata1);
        }
        for(var j = 0; j < info.identity.length; j++) {
            var basedata2 = []; //[[其他], [教职工], [本科生], [研究生]]
            basedata2.push(info.sum[j]);
            basedata2.push(info.sum[j + info.identity.length]);
            basedata2.push(info.sum[j + info.identity.length * 2]);
            barchartdata.push(basedata2);
        }
        tablehead.push(info.identity[2]);
        replace["ident1"] = info.identity[2];
        tablehead.push(info.identity[3]);
        replace["ident2"] = info.identity[3];
        tablehead.push(info.identity[1]);
        replace["ident3"] = info.identity[1];
        tablehead.push(info.identity[0]);
        replace["ident4"] = info.identity[0];
        var param = {
            tablehead: tablehead,
            tabledata: tabledata
        };
        var chartdata = [];
        for(var i=0;i<tabledata.length;i++){
            var basedata = new Object();
            basedata["13-1-1"] = tabledata[i].year;
            basedata["13-1-2"] = tabledata[i][0][2].value;
            basedata["13-1-3"] = tabledata[i][0][3].value;
            basedata["13-1-4"] = tabledata[i][0][1].value;
            basedata["13-1-5"] = tabledata[i][0][0].value;
            basedata["13-1-6"] = tabledata[i].sum;
            chartdata.push(basedata);
        }
        replace["table_library_report_identity_sum"] = chartdata;
        var html = template('tableLibraryReportIdentitySum',{param:param});
        $(".tableLibraryReportIdentitySum").html(html);
        $(".library_report_identity_sum").find(".sec-year").text(info.year[0]);
        $(".second-catalog").find(".sec-year").text(info.year[0]);
        replace["sec-year"] = info.year[0];
        $(".library_report_identity_sum").find(".max-year").text(info.year[2]);
        $(".second-catalog").find(".max-year").text(info.year[2]);
        replace["max-year"] = info.year[2];
        $("#table_library_report_identity_sum_title").text(info.year[0] + "-" + info.year[2] + "年各类型读者入馆总人次统计表");
        replace["table_library_report_identity_sum_title"] = info.year[0] + "-" + info.year[2] + "年各类型读者入馆总人次统计表";
        $("#barchart_library_report_identity_sum_title").text(info.year[0] + "-" + info.year[2] + "年各类型读者入馆总人次统计图");
        replace["barchart_library_report_identity_sum_title"] = info.year[0] + "-" + info.year[2] + "年各类型读者入馆总人次统计图";
        $("#piechart1_library_report_identity_sum_title").text(info.year[0] + "年度各类型读者占入馆总人次百分比");
        replace["piechart1_library_report_identity_sum_title"] = info.year[0] + "年度各类型读者占入馆总人次百分比";
        $("#piechart2_library_report_identity_sum_title").text(info.year[1] + "年度各类型读者占入馆总人次百分比");
        replace["piechart2_library_report_identity_sum_title"] = info.year[1] + "年度各类型读者占入馆总人次百分比";
        $("#piechart3_library_report_identity_sum_title").text(info.year[2] + "年度各类型读者占入馆总人次百分比");
        replace["piechart3_library_report_identity_sum_title"] = info.year[2] + "年度各类型读者占入馆总人次百分比";
        var barchart_library_report_identity_sum = echarts.init(document.getElementById('barchart_library_report_identity_sum'));
        var barchart_library_report_identity_sum_option = {
            animation:false,
            backgroundColor:'white',
            tooltip : {
                trigger: 'axis'
            },
            calculable : true,
            legend: {
                data: tablehead,
                align: 'left',
                left: 'center'
            },
            xAxis : [
                {
                    type : 'category',
                    data : info.year,
                    name : "年"
                }
            ],
            yAxis : [
                {
                    name : "人次",
                    type : 'value'
                }
            ],
            series : [
                {
                    name:tablehead[3],
                    type:'bar',
                    data:barchartdata[0],
                    label: {
                        normal: {
                            show: true,
                            position: 'top',
                            formatter: '{c}'
                        }
                    }
                },
                {
                    name:tablehead[2],
                    type:'bar',
                    data:barchartdata[1],
                    label: {
                        normal: {
                            show: true,
                            position: 'top',
                            formatter: '{c}'
                        }
                    }
                },
                {
                    name:tablehead[0],
                    type:'bar',
                    data:barchartdata[2],
                    label: {
                        normal: {
                            show: true,
                            position: 'top',
                            formatter: '{c}'
                        }
                    }
                },
                {
                    name:tablehead[1],
                    type:'bar',
                    data:barchartdata[3],
                    label: {
                        normal: {
                            show: true,
                            position: 'top',
                            formatter: '{c}'
                        }
                    }
                }
            ]
        };
        barchart_library_report_identity_sum.setOption(barchart_library_report_identity_sum_option);
        var piechart1_library_report_identity_sum = echarts.init(document.getElementById('piechart1_library_report_identity_sum'));
        var piechart1_library_report_identity_sum_option = {
            animation:false,
            backgroundColor:'white',
            calculable : true,
            series : [
                {
                    type: 'pie',
                    radius : '55%',
                    center: ['50%', '50%'],
                    data:tabledata[0][0],
                    label: {
                        normal: {
                            show: true,
                            position: 'top',
                            formatter: '{b} {d}%'
                        }
                    },
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        piechart1_library_report_identity_sum.setOption(piechart1_library_report_identity_sum_option);
        var piechart2_library_report_identity_sum = echarts.init(document.getElementById('piechart2_library_report_identity_sum'));
        var piechart2_library_report_identity_sum_option = {
            animation:false,
            backgroundColor:'white',
            calculable : true,
            series : [
                {
                    type: 'pie',
                    radius : '55%',
                    center: ['50%', '50%'],
                    data:tabledata[1][0],
                    label: {
                        normal: {
                            show: true,
                            position: 'top',
                            formatter: '{b} {d}%'
                        }
                    },
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        piechart2_library_report_identity_sum.setOption(piechart2_library_report_identity_sum_option);
        var piechart3_library_report_identity_sum = echarts.init(document.getElementById('piechart3_library_report_identity_sum'));
        var piechart3_library_report_identity_sum_option = {
            animation:false,
            backgroundColor:'white',
            calculable : true,
            series : [
                {
                    type: 'pie',
                    radius : '55%',
                    center: ['50%', '50%'],
                    data:tabledata[2][0],
                    label: {
                        normal: {
                            show: true,
                            position: 'top',
                            formatter: '{b} {d}%'
                        }
                    },
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        piechart3_library_report_identity_sum.setOption(piechart3_library_report_identity_sum_option);
    })
}

function library_report_ic_total() {
    $.get('../../schoolReport/library_report_ic_total',function (info) {
        var param = [];
        var year = [];
        var sum = [0, 0, 0];
        var month = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12];
        var data = [];
        var sumIndex = 0;
        for(key in info) {
            year.push(key);
            var index = key;
            var monthIndex = 0;
            var tempdata = [];
            for(key in info[index]) {
                while(key != month[monthIndex]) {
                    tempdata.push(0);
                    monthIndex++;
                }
                tempdata.push(info[index][key]);
                sum[sumIndex] += info[index][key];
                monthIndex++;
            }
            param.push({
                "year": index,
                "sum": sum[sumIndex]
            });
            sumIndex++;
            for(var i = monthIndex; i < 12; i++){
                tempdata.push(0);
            }
            data.push(tempdata);
        }
        var library_report_ic_total = echarts.init(document.getElementById('library_report_ic_total'));
        var library_report_ic_total_option = {
            animation:false,
            backgroundColor:'white',
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data:year
            },
            xAxis: {
                type: 'category',
                boundaryGap: false,
                data: month,
                name: '月份'
            },
            yAxis: {
                type: 'value',
                name: '人次'
            },
            series: [
                {
                    name:year[0],
                    type:'line',
                    data:data[0]
                },
                {
                    name:year[1],
                    type:'line',
                    data:data[1]
                },
                {
                    name:year[2],
                    type:'line',
                    data:data[2]
                }
            ]
        };
        library_report_ic_total.setOption(library_report_ic_total_option);
        $(".ic-total").find(".max-year").text(year[2]);
        replace["max-year2"] = year[2];
        $(".ic-total").find(".sec-year").text(year[1]);
        replace["sec-year2"] = year[1];
        $(".ic-total").find(".max-total").text(sum[2]);
        replace["max-total"] = sum[2];
        $(".ic-total").find(".sec-total").text(sum[1]);
        replace["sec-total"] = sum[1];
        var change = sum[2] - sum[1];
        if (change < 0) {
            $(".ic-total").find(".change").text("减少");
            $(".ic-total").find(".change-number").text(sum[1] - sum[2]);
            $(".ic-total").find(".change-percent").text(((sum[1] - sum[2]) / sum[2] * 100).toFixed(2));
            replace["change-number"] = "减少" + sum[1] - sum[2];
            replace["change-percent"] = "减少" + ((sum[1] - sum[2]) / sum[2] * 100).toFixed(2);
        } else {
            $(".ic-total").find(".change").text("增加");
            $(".ic-total").find(".change-number").text(sum[2] - sum[1]);
            $(".ic-total").find(".change-percent").text(((sum[2] - sum[1]) / sum[2] * 100).toFixed(2));
            replace["change-number"] = "增加" + (sum[1] - sum[2]);
            replace["change-percent"] = "增加" + ((sum[1] - sum[2]) / sum[2] * 100).toFixed(2);
        }
        $(".ic-total-year").text(year[0] + "-" + year[2]);
        replace["ic-total-year"] = year[0] + "-" + year[2];
        replace["ic-total-year2"] = year[0] + "-" + year[2];
        replace["img-ic-total-year"] = year[0] + "-" + year[2];
        replace["img-ic-total-year2"] = year[0] + "-" + year[2];
        var html = template('tableLibraryReportIcTotal',{param:param}); //历年上机总人次统计表
        $(".tableLibraryReportIcTotal").html(html);
        var tabledata = [];
        for(var i=0;i<param.length;i++){
            var chartbasedata = new Object();
            chartbasedata["year"] = param[i].year;
            chartbasedata["sum"] = param[i].sum;
            tabledata.push(chartbasedata);
        }
        replace["tableLibraryReportIcTotal"] = tabledata;
        var library_report_ic_total_2 = echarts.init(document.getElementById('library_report_ic_total_2'));
        var library_report_ic_total_option_2 = {
            animation:false,
            backgroundColor:'white',
            color: ['#3398DB'],
            tooltip : {
                trigger: 'axis',
            },
            xAxis : [
                {
                    type : 'category',
                    data : year,
                    name : '年份',
                    axisTick: {
                        alignWithLabel: true
                    }
                }
            ],
            yAxis : [
                {
                    type : 'value',
                    name : '人次'
                }
            ],
            series : [
                {
                    name:'总人次',
                    type:'bar',
                    barWidth: '60%',
                    data:sum,
                    label: {
                        normal: {
                            show: true,
                            color: 'black',
                            position: 'top',
                            formatter: '{c}'
                        }
                    }
                }
            ]
        };
        library_report_ic_total_2.setOption(library_report_ic_total_option_2);
    })
}

function getDailyLendPeopleAndCount() {
    $.get('../../schoolReport/getDailyLendPeopleAndCount',function (info) {
        var getDailyLendPeopleAndCount = echarts.init(document.getElementById('getDailyLendPeopleAndCount'));
        var getDailyLendPeopleAndCount_option = {
            animation:false,
            backgroundColor:'white',
            xAxis: {
                type: 'category',
                data: info.ymddate,
                name: '时间',
                axisLabel:{
                    rotate: 45,
                    interval: 10
                }
            },
            yAxis: {
                type: 'value',
                name: '数量'
            },
            legend: {
                data:['借阅人数','借阅册数']
            },
            tooltip : {
                trigger: 'axis'
            },
            series: [
                {
                    data: info.book_lend_people,
                    type: 'line',
                    name: '借阅人数',
                    showSymbol: false
                },
                {
                    data: info.book_lend_times,
                    type: 'line',
                    name: '借阅册数',
                    showSymbol: false
                }
            ]
        };
        getDailyLendPeopleAndCount.setOption(getDailyLendPeopleAndCount_option);
    });
}

function getCirculationByHour() {
    $.get('../../schoolReport/getCirculationByHour',function (info) {
        var param = [];
        var hour = [];
        var book_renew_times = [];
        var book_back_times = [];
        var book_lend_times = [];
        var temp_book_renew_times = 0;
        var temp_book_back_times = 0;
        var temp_book_lend_times = 0;
        for(var i = 0; i < info.hour.length; i++) {
            if(info.hour[i] < 8) {
                temp_book_renew_times += info.book_renew_times[i];
                temp_book_back_times += info.book_back_times[i];
                temp_book_lend_times += info.book_lend_times[i];
            } else if(info.hour[i] == 8) {
                param.push({
                    hour: '8:00以前',
                    book_renew_times: temp_book_renew_times,
                    daily_average_book_renew_times: (temp_book_renew_times / 365).toFixed(2),
                    book_back_times: temp_book_back_times,
                    daily_average_book_back_times: (temp_book_back_times / 365).toFixed(2),
                    book_lend_times: temp_book_lend_times,
                    daily_average_book_lend_times: (temp_book_lend_times / 365).toFixed(2)
                });
                hour.push('8:00以前');
                book_renew_times.push(temp_book_renew_times);
                book_back_times.push(temp_book_back_times);
                book_lend_times.push(temp_book_lend_times);
                temp_book_renew_times += info.book_renew_times[i];
                temp_book_back_times += info.book_back_times[i];
                temp_book_lend_times += info.book_lend_times[i];
                param.push({
                    hour: '8:00-8:59',
                    book_renew_times: info.book_renew_times[i],
                    daily_average_book_renew_times: (info.book_renew_times[i] / 365).toFixed(2),
                    book_back_times: info.book_back_times[i],
                    daily_average_book_back_times: (info.book_back_times[i] / 365).toFixed(2),
                    book_lend_times: info.book_lend_times[i],
                    daily_average_book_lend_times: (info.book_lend_times[i] / 365).toFixed(2)
                });
                hour.push('8:00-8:59');
                book_renew_times.push(info.book_renew_times[i]);
                book_back_times.push(info.book_back_times[i]);
                book_lend_times.push(info.book_lend_times[i]);
            } else {
                temp_book_renew_times += info.book_renew_times[i];
                temp_book_back_times += info.book_back_times[i];
                temp_book_lend_times += info.book_lend_times[i];
                param.push({
                    hour: info.hour[i] + ':00' + '-' + info.hour[i] + ':59',
                    book_renew_times: info.book_renew_times[i],
                    daily_average_book_renew_times: (info.book_renew_times[i] / 365).toFixed(2),
                    book_back_times: info.book_back_times[i],
                    daily_average_book_back_times: (info.book_back_times[i] / 365).toFixed(2),
                    book_lend_times: info.book_lend_times[i],
                    daily_average_book_lend_times: (info.book_lend_times[i] / 365).toFixed(2)
                });
                hour.push(info.hour[i] + ':00' + '-' + info.hour[i] + ':59');
                book_renew_times.push(info.book_renew_times[i]);
                book_back_times.push(info.book_back_times[i]);
                book_lend_times.push(info.book_lend_times[i]);
            }
        }
        param.push({
            hour: '总计',
            book_renew_times: temp_book_renew_times,
            daily_average_book_renew_times: (temp_book_renew_times / 365).toFixed(2),
            book_back_times: temp_book_back_times,
            daily_average_book_back_times: (temp_book_back_times / 365).toFixed(2),
            book_lend_times: temp_book_lend_times,
            daily_average_book_lend_times: (temp_book_lend_times / 365).toFixed(2)
        });
        var html = template('tableGetCirculationByHour',{param:param});
        $(".tableGetCirculationByHour").html(html);
        var tabledata = [];
        for(var i=0;i<param.length;i++){
            var tablebasedata = new Object();
            tablebasedata["21-1-1"] = param[i].hour;
            tablebasedata["21-1-2"] = param[i].book_lend_times;
            tablebasedata["21-1-3"] = param[i].daily_average_book_lend_times;
            tablebasedata["21-1-4"] = param[i].book_back_times;
            tablebasedata["21-1-5"] = param[i].daily_average_book_back_times;
            tablebasedata["21-1-6"] = param[i].book_renew_times;
            tablebasedata["21-1-7"] = param[i].daily_average_book_renew_times;
            tabledata.push(tablebasedata);
        }
        replace["tableGetCirculationByHour"] = tabledata;
        var getCirculationByHour = echarts.init(document.getElementById('getCirculationByHour'));
        var getCirculationByHour_option = {
            animation:false,
            backgroundColor:'white',
            xAxis: {
                type: 'category',
                data: hour,
                axisLabel:{
                    rotate: 45,
                    interval: 0
                },
                axisLine: {onZero: true},
                name: '时间',
            },
            yAxis: {
                type: 'value',
                name: '册数'
            },
            legend: {
                data:['借出','还回','续借']
            },
            tooltip : {
                trigger: 'axis',
            },
            series: [
                {
                    data: book_lend_times,
                    type: 'line',
                    name: '借出'
                },
                {
                    data: book_back_times,
                    type: 'line',
                    name: '还回'
                },
                {
                    data: book_renew_times,
                    type: 'line',
                    name: '续借'
                }
            ]
        };
        getCirculationByHour.setOption(getCirculationByHour_option);
    })
}

function getLibraryTypeTimes() {
    var paramYear = nowyear.toString();
    $.get('../../schoolReport/getLibraryTypeTimes', paramYear, function (info) {
        var arrayYear = [nowyear - 2, nowyear - 1, nowyear];
        var param1 = []; //打复扫人次
        var param2 = []; //打复扫数量
        var tempdata1 = []; //打复扫人次数据临时存放
        var tempdata2 = []; //打复扫数量数据临时存放
        var address = [];
        var index = 0;
        for(var ii = 0; ii < 3; ii++) {
            index = 3 * ii;
            var data1 = [];
            var data2 = [];
            for (var i = 0; i < info.length; i++) {
                for (var j = index; j < index + 3; j++) {
                    data1.push(info[i][j][2]);
                    data2.push(info[i][j][3]);
                }
            }
            address.push(info[ii][index][1]);
            tempdata1.push({
                address: info[ii][index][1],
                data: data1
            });
            tempdata2.push({
                address: info[ii][index][1],
                data: data2
            });
        }
        param1.push({
            year: arrayYear,
            dataArray: tempdata1
        });
        param2.push({
            year: arrayYear,
            dataArray: tempdata2
        });
        var html = template('tableGetLibraryTypeTimes',{param:param1});
        $(".tableGetLibraryTypeTimes").html(html);
        console.log(param1[0]);
        replace["22-1-1"] = arrayYear[0];
        replace["22-1-2"] = arrayYear[1];
        replace["22-1-3"] = arrayYear[2];
        replace["23-1-1"] = arrayYear[0];
        replace["23-1-2"] = arrayYear[1];
        replace["23-1-3"] = arrayYear[2];
        var tabledata = [];
        for(var i=0;i<param1[0].dataArray.length;i++){
            var tablebasedata = new Object();
            tablebasedata["22-1"] = param1[0].dataArray[i].address;
            tablebasedata["22-2"] = param1[0].dataArray[i].data[0];
            tablebasedata["22-3"] = param1[0].dataArray[i].data[1];
            tablebasedata["22-4"] = param1[0].dataArray[i].data[2];
            tablebasedata["22-5"] = param1[0].dataArray[i].data[3];
            tablebasedata["22-6"] = param1[0].dataArray[i].data[4];
            tablebasedata["22-7"] = param1[0].dataArray[i].data[5];
            tablebasedata["22-8"] = param1[0].dataArray[i].data[6];
            tablebasedata["22-9"] = param1[0].dataArray[i].data[7];
            tablebasedata["22-0"] = param1[0].dataArray[i].data[8];
            tabledata.push(tablebasedata);
        }
        replace["tableGetLibraryTypeTimes"] = tabledata;
        html = template('tableGetLibraryTypeTimes',{param:param2});
        $(".tableGetLibraryTypeSum").html(html);
        var tabledata1 = [];
        for(var i=0;i<param2[0].dataArray.length;i++){
            var tablebasedata = new Object();
            tablebasedata["23-1"] = param2[0].dataArray[i].address;
            tablebasedata["23-2"] = param2[0].dataArray[i].data[0];
            tablebasedata["23-3"] = param2[0].dataArray[i].data[1];
            tablebasedata["23-4"] = param2[0].dataArray[i].data[2];
            tablebasedata["23-5"] = param2[0].dataArray[i].data[3];
            tablebasedata["23-6"] = param2[0].dataArray[i].data[4];
            tablebasedata["23-7"] = param2[0].dataArray[i].data[5];
            tablebasedata["23-8"] = param2[0].dataArray[i].data[6];
            tablebasedata["23-9"] = param2[0].dataArray[i].data[7];
            tablebasedata["23-0"] = param2[0].dataArray[i].data[8];
            tabledata1.push(tablebasedata);
        }
        replace["tableGetLibraryTypeSum"] = tabledata1;
        $(".library-type-times").find(".max-year").text(arrayYear[2]);
        $(".library-type-times").find(".sec-year").text(arrayYear[0]);
        replace["max-sec-year"] = arrayYear[0] + "-" + arrayYear[2];

        var sumCopyByYearTimes = [0, 0, 0];
        var sumPrintByYearTimes = [0, 0, 0];
        var sumScanningByYearTimes = [0, 0, 0];
        var sumCopyByYearNum = [0, 0, 0];
        var sumPrintByYearNum = [0, 0, 0];
        var sumScanningByYearNum = [0, 0, 0];
        for(var n = 0; n < 3; n++) {
            for (var i = 0; i < tempdata1.length; i++) {
                for (var j = n * 3; j < n * 3 + 3; j++) {
                    if (j % 3 == 0) {
                        sumCopyByYearTimes[n] += Number(tempdata1[i].data[j]);
                        sumCopyByYearNum[n] += Number(tempdata2[i].data[j]);
                    } else if (j % 3 == 1) {
                        sumPrintByYearTimes[n] += Number(tempdata1[i].data[j]);
                        sumPrintByYearNum[n] += Number(tempdata2[i].data[j]);
                    } else if (j % 3 == 2) {
                        sumScanningByYearTimes[n] += Number(tempdata1[i].data[j]);
                        sumScanningByYearNum[n] += Number(tempdata2[i].data[j]);
                    }
                }
            }
        }
        var chartSumCopyByYearTimes = echarts.init(document.getElementById('getSumCopyByYearTimes'));
        var chartSumCopyByYearTimes_option = {
            animation:false,
            backgroundColor:'white',
            color: ['#3398DB'],
            xAxis: {
                type: 'category',
                data: arrayYear,
                axisLine: {onZero: true},
                name: '年',
            },
            yAxis: {
                type: 'value',
                name: '人次'
            },
            tooltip : {
                trigger: 'axis',
            },
            series: [
                {
                    data: sumCopyByYearTimes,
                    name: '总人次',
                    type: 'bar',
                    barWidth: '60%',
                    label: {
                        normal: {
                            show: true,
                            color: 'black',
                            position: 'top',
                            formatter: '{c}'
                        }
                    }
                }
            ]
        };
        chartSumCopyByYearTimes.setOption(chartSumCopyByYearTimes_option);
        var chartPrintCopyByYearTimes = echarts.init(document.getElementById('getSumPrintByYearTimes'));
        var chartPrintCopyByYearTimes_option = {
            animation:false,
            backgroundColor:'white',
            color: ['#3398DB'],
            xAxis: {
                type: 'category',
                data: arrayYear,
                axisLine: {onZero: true},
                name: '年',
            },
            yAxis: {
                type: 'value',
                name: '人次'
            },
            tooltip : {
                trigger: 'axis',
            },
            series: [
                {
                    data: sumPrintByYearTimes,
                    name: '总人次',
                    type: 'bar',
                    barWidth: '60%',
                    label: {
                        normal: {
                            show: true,
                            color: 'black',
                            position: 'top',
                            formatter: '{c}'
                        }
                    }
                }
            ]
        };
        chartPrintCopyByYearTimes.setOption(chartPrintCopyByYearTimes_option);
        var chartScanningCopyByYearTimes = echarts.init(document.getElementById('getSumScanningByYearTimes'));
        var chartScanningCopyByYearTimes_option = {
            animation:false,
            backgroundColor:'white',
            color: ['#3398DB'],
            xAxis: {
                type: 'category',
                data: arrayYear,
                axisLine: {onZero: true},
                name: '年',
            },
            yAxis: {
                type: 'value',
                name: '人次'
            },
            tooltip : {
                trigger: 'axis',
            },
            series: [
                {
                    data: sumScanningByYearTimes,
                    name: '总人次',
                    type: 'bar',
                    barWidth: '60%',
                    label: {
                        normal: {
                            show: true,
                            color: 'black',
                            position: 'top',
                            formatter: '{c}'
                        }
                    }
                }
            ]
        };
        chartScanningCopyByYearTimes.setOption(chartScanningCopyByYearTimes_option);

        var chartSumCopyByYearNum = echarts.init(document.getElementById('getSumCopyByYearNum'));
        var chartSumCopyByYearNum_option = {
            animation:false,
            backgroundColor:'white',
            color: ['#3398DB'],
            xAxis: {
                type: 'category',
                data: arrayYear,
                axisLine: {onZero: true},
                name: '年',
            },
            yAxis: {
                type: 'value',
                name: '数量（页）'
            },
            tooltip : {
                trigger: 'axis',
            },
            series: [
                {
                    data: sumCopyByYearNum,
                    name: '总数量',
                    type: 'bar',
                    barWidth: '60%',
                    label: {
                        normal: {
                            show: true,
                            color: 'black',
                            position: 'top',
                            formatter: '{c}'
                        }
                    }
                }
            ]
        };
        chartSumCopyByYearNum.setOption(chartSumCopyByYearNum_option);
        var chartPrintCopyByYearNum = echarts.init(document.getElementById('getSumPrintByYearNum'));
        var chartPrintCopyByYearNum_option = {
            animation:false,
            backgroundColor:'white',
            color: ['#3398DB'],
            xAxis: {
                type: 'category',
                data: arrayYear,
                axisLine: {onZero: true},
                name: '年',
            },
            yAxis: {
                type: 'value',
                name: '数量（页）'
            },
            tooltip : {
                trigger: 'axis',
            },
            series: [
                {
                    data: sumPrintByYearNum,
                    name: '总数量',
                    type: 'bar',
                    barWidth: '60%',
                    label: {
                        normal: {
                            show: true,
                            color: 'black',
                            position: 'top',
                            formatter: '{c}'
                        }
                    }
                }
            ]
        };
        chartPrintCopyByYearNum.setOption(chartPrintCopyByYearNum_option);
        var chartScanningCopyByYearNum = echarts.init(document.getElementById('getSumScanningByYearNum'));
        var chartScanningCopyByYearNum_option = {
            animation:false,
            backgroundColor:'white',
            color: ['#3398DB'],
            xAxis: {
                type: 'category',
                data: arrayYear,
                axisLine: {onZero: true},
                name: '年',
            },
            yAxis: {
                type: 'value',
                name: '数量（页）'
            },
            tooltip : {
                trigger: 'axis',
            },
            series: [
                {
                    data: sumScanningByYearNum,
                    name: '总数量',
                    type: 'bar',
                    barWidth: '60%',
                    label: {
                        normal: {
                            show: true,
                            color: 'black',
                            position: 'top',
                            formatter: '{c}'
                        }
                    }
                }
            ]
        };
        chartScanningCopyByYearNum.setOption(chartScanningCopyByYearNum_option);
    })
}

function getUndergraduateBorrowingSituation() {
    $.get('../../schoolReport/getUndergraduateBorrowingSituation', function (info) {
        var html = template('tableGetBorrowingSituation',{param:info});
        $(".tableGetUndergraduateBorrowingSituation").html(html);
        var tabledata = [];
        for(var i=0;i<info.length;i++){
            var chartbasedata = new Object();
            chartbasedata["14-1-1"] = info[i].academy;
            chartbasedata["14-1-2"] = info[i].reader_number;
            chartbasedata["14-1-3"] = info[i].lend_number;
            chartbasedata["14-1-4"] = info[i].percentage_of_borrowing;
            tabledata.push(chartbasedata);
        }
        replace["tableGetUndergraduateBorrowingSituation"] = tabledata;
        var academy = [];
        var percent = [];
        for(var i = 0; i < info.length; i++){
            academy.push(info[i].academy);
            percent.push(info[i].percentage_of_borrowing);
        }
        var chartGetUndergraduateBorrowingSituation = echarts.init(document.getElementById('getUndergraduateBorrowingSituation'));
        var getUndergraduateBorrowingSituationoption = {
            //color: ['#3398DB'],
            animation:false,
            tooltip: {
                trigger: 'axis',
                backgroundColor:'rgba(255,255,255,0.8)',
                extraCssText: 'box-shadow: 0 0 8px rgba(0, 0, 0, 0.3);',
                textStyle:{
                    color:'#6a717b',
                },
                formatter: '{c}%'
            },
            grid: {
                left: '2%',
                right: '8%',
                bottom: '5%',
                containLabel: true
            },
            yAxis: [{
                name:'院系',
                type: 'category',
                data: academy,
                axisTick: {
                    alignWithLabel: true
                },
                axisLabel: {
                    margin: 10,
                    textStyle: {
                        fontSize: 12,
                        color:'#94999f'
                    }
                },
                axisLine: {
                    lineStyle: {
                        color: '#999'
                    }
                }

            }],
            xAxis: [{
                type: 'value',
                axisLabel: {
                    margin: 10,
                    textStyle: {
                        fontSize: 12,
                        color:'#94999f'
                    }
                },
                axisLine: {
                    lineStyle: {
                        color: '#fff'
                    }
                },
                splitLine: {
                    lineStyle: {
                        color: '#dbe0e6'
                    }
                }



            }],
            backgroundColor: '#ffffff',
            series: [{
                name: '借阅人数百分比',
                type: 'bar',
                barWidth:'80%',
                data: percent,
                label: {
                    normal: {
                        show: false,
                        position: 'insideRight',
                        textStyle: {
                            color: '#666', //color of value
                            position:'right'
                        }
                    }
                },


                itemStyle: {

                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 1, 0, [{
                            offset: 0,
                            color: '#64bdc8' // 0% 处的颜色
                        }, {
                            offset: 1,
                            color: '#00c484' // 100% 处的颜色
                        }], false),
                        barBorderRadius: [0, 15,15, 0],
                        shadowColor: 'rgba(0,0,0,0.1)',
                        shadowBlur: 3,
                        shadowOffsetY: 3
                    }
                }
            }]
        };
        chartGetUndergraduateBorrowingSituation.setOption(getUndergraduateBorrowingSituationoption);
    });
}

function getGraduateBorrowingSituation() {
    $.get('../../schoolReport/getGraduateBorrowingSituation', function (info) {
        var html = template('tableGetBorrowingSituation',{param:info});
        $(".tableGetGraduateBorrowingSituation").html(html);
        var tabledata = [];
        for(var i=0;i<info.length;i++){
            var chartbasedata = new Object();
            chartbasedata["15-1-1"] = info[i].academy;
            chartbasedata["15-1-2"] = info[i].reader_number;
            chartbasedata["15-1-3"] = info[i].lend_number;
            chartbasedata["15-1-4"] = info[i].percentage_of_borrowing;
            tabledata.push(chartbasedata);
        }
        replace["tableGetGraduateBorrowingSituation"] = tabledata;
        var academy = [];
        var percent = [];
        for(var i = 0; i < info.length; i++){
            academy.push(info[i].academy);
            percent.push(info[i].percentage_of_borrowing);
        }
        var chartGetGraduateBorrowingSituation = echarts.init(document.getElementById('getGraduateBorrowingSituation'));
        var getGraduateBorrowingSituationoption = {
            //color: ['#3398DB'],
            animation:false,
            tooltip: {
                trigger: 'axis',
                backgroundColor:'rgba(255,255,255,0.8)',
                extraCssText: 'box-shadow: 0 0 8px rgba(0, 0, 0, 0.3);',
                textStyle:{
                    color:'#6a717b',
                },
                formatter: '{c}%'
            },
            grid: {
                left: '2%',
                right: '8%',
                bottom: '5%',
                containLabel: true
            },
            yAxis: [{
                name:'院系',
                type: 'category',
                data: academy,
                axisTick: {
                    alignWithLabel: true
                },
                axisLabel: {
                    margin: 10,
                    textStyle: {
                        fontSize: 12,
                        color:'#94999f'
                    }
                },
                axisLine: {
                    lineStyle: {
                        color: '#999'
                    }
                }

            }],
            xAxis: [{
                type: 'value',
                axisLabel: {
                    margin: 10,
                    textStyle: {
                        fontSize: 12,
                        color:'#94999f'
                    }
                },
                axisLine: {
                    lineStyle: {
                        color: '#fff'
                    }
                },
                splitLine: {
                    lineStyle: {
                        color: '#dbe0e6'
                    }
                }



            }],
            backgroundColor: '#ffffff',
            series: [{
                name: '借阅人数百分比',
                type: 'bar',
                barWidth:'80%',
                data: percent,
                label: {
                    normal: {
                        show: false,
                        position: 'insideRight',
                        textStyle: {
                            color: '#666', //color of value
                            position:'right'
                        }
                    }
                },


                itemStyle: {

                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 1, 0, [{
                            offset: 0,
                            color: '#64bdc8' // 0% 处的颜色
                        }, {
                            offset: 1,
                            color: '#00c484' // 100% 处的颜色
                        }], false),
                        barBorderRadius: [0, 15,15, 0],
                        shadowColor: 'rgba(0,0,0,0.1)',
                        shadowBlur: 3,
                        shadowOffsetY: 3
                    }
                }
            }]
        };
        chartGetGraduateBorrowingSituation.setOption(getGraduateBorrowingSituationoption);
    });
}

function getPerCapitaBorrowingAmount() {
    $.get('../../schoolReport/getPerCapitaBorrowingAmount', function (info) {
        var html = template('tableGetPerCapitaBorrowingAmount',{param:info});
        $(".tableGetPerCapitaBorrowingAmount").html(html);
        var tabledata = [];
        for(var i=0;i<info.length;i++){
            var tablebasedata = new Object();
            tablebasedata["16-1-1"] = info[i].identity;
            tablebasedata["16-1-2"] = info[i].reader_number;
            tablebasedata["16-1-3"] = info[i].lend_number;
            tablebasedata["16-1-4"] = info[i].lend_total;
            tablebasedata["16-1-5"] = info[i].reader_per_person;
            tablebasedata["16-1-6"] = info[i].academy_per_person;
            tabledata.push(tablebasedata);
        }
        replace["tableGetPerCapitaBorrowingAmount"] = tabledata;
        var identity = [];
        var reader_per_person = [];
        var academy_per_person = [];
        for(var i = 0; i < info.length; i++){
            identity.push(info[i].identity);
            reader_per_person.push(info[i].reader_per_person);
            academy_per_person.push(info[i].academy_per_person);
        }
        var chartGetPerCapitaBorrowingAmount = echarts.init(document.getElementById('getPerCapitaBorrowingAmount'));
        var chartGetPerCapitaBorrowingAmount_option = {
            animation:false,
            backgroundColor:'white',
            tooltip : {
                trigger: 'axis'
            },
            calculable : true,
            legend: {
                data: ['有借阅的读者平均借阅册数', '全部读者平均借阅册数'],
                align: 'left',
                left: 'center'
            },
            xAxis : [
                {
                    type : 'category',
                    data : identity,
                    name : "读者类型"
                }
            ],
            yAxis : [
                {
                    name : "平均借阅册数",
                    type : 'value'
                }
            ],
            series : [
                {
                    name:'有借阅的读者平均借阅册数',
                    type:'bar',
                    data:reader_per_person,
                    label: {
                        normal: {
                            show: true,
                            position: 'top',
                            formatter: '{c}'
                        }
                    }
                },
                {
                    name:'全部读者平均借阅册数',
                    type:'bar',
                    data:academy_per_person,
                    label: {
                        normal: {
                            show: true,
                            position: 'top',
                            formatter: '{c}'
                        }
                    }
                }
            ]
        };
        chartGetPerCapitaBorrowingAmount.setOption(chartGetPerCapitaBorrowingAmount_option);
    });
}

function getUndergraduatePerCapitaBorrowingAmount() {
    $.get('../../schoolReport/getUndergraduatePerCapitaBorrowingAmount', function (info) {
        var html = template('tableGetPerCapitaBorrowingAmountByAcademy',{param:info});
        $(".tableGetUndergraduatePerCapitaBorrowingAmount").html(html);
        var tabledata = [];
        for(var i=0;i<info.length;i++){
            var tablebasedata = new Object();
            tablebasedata["17-1-1"] = info[i].academy;
            tablebasedata["17-1-2"] = info[i].reader_number;
            tablebasedata["17-1-3"] = info[i].lend_number;
            tablebasedata["17-1-4"] = info[i].lend_total;
            tablebasedata["17-1-5"] = info[i].reader_per_person;
            tablebasedata["17-1-6"] = info[i].academy_per_person;
            tabledata.push(tablebasedata);
        }
        replace["tableGetUndergraduatePerCapitaBorrowingAmount"] = tabledata;
        var academy = [];
        var reader_per_person = [];
        var academy_per_person = [];
        for(var i = 0; i < info.length; i++){
            academy.push(info[i].academy);
            reader_per_person.push(info[i].reader_per_person);
            academy_per_person.push(info[i].academy_per_person);
        }
        var chartGetUndergraduatePerCapitaBorrowingAmount = echarts.init(document.getElementById('getUndergraduatePerCapitaBorrowingAmount'));
        var chartGetUndergraduatePerCapitaBorrowingAmount_option = {
            animation:false,
            backgroundColor:'white',
            tooltip: {
                trigger: 'axis',
            },
            legend: {
                data: ['人均册数', '全院系人均册数']
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis: {
                type: 'value',
                boundaryGap: [0, 0.01]
            },
            yAxis: {
                type: 'category',
                data: academy
            },
            series: [
                {
                    name: '人均册数',
                    type: 'bar',
                    data: reader_per_person
                },
                {
                    name: '全院系人均册数',
                    type: 'bar',
                    data: academy_per_person
                }
            ]
        };
        chartGetUndergraduatePerCapitaBorrowingAmount.setOption(chartGetUndergraduatePerCapitaBorrowingAmount_option);
    });
}

function getGraduatePerCapitaBorrowingAmount() {
    $.get('../../schoolReport/getGraduatePerCapitaBorrowingAmount', function (info) {
        var html = template('tableGetPerCapitaBorrowingAmountByAcademy',{param:info});
        $(".tableGetGraduatePerCapitaBorrowingAmount").html(html);
        var tabledata = [];
        for(var i=0;i<info.length;i++){
            var tablebasedata = new Object();
            tablebasedata["18-1-1"] = info[i].academy;
            tablebasedata["18-1-2"] = info[i].reader_number;
            tablebasedata["18-1-3"] = info[i].lend_number;
            tablebasedata["18-1-4"] = info[i].lend_total;
            tablebasedata["18-1-5"] = info[i].reader_per_person;
            tablebasedata["18-1-6"] = info[i].academy_per_person;
            tabledata.push(tablebasedata);
        }
        replace["tableGetGraduatePerCapitaBorrowingAmount"] = tabledata;
        var academy = [];
        var reader_per_person = [];
        var academy_per_person = [];
        for(var i = 0; i < info.length; i++){
            academy.push(info[i].academy);
            reader_per_person.push(info[i].reader_per_person);
            academy_per_person.push(info[i].academy_per_person);
        }
        var chartGetGraduatePerCapitaBorrowingAmount = echarts.init(document.getElementById('getGraduatePerCapitaBorrowingAmount'));
        var chartGetGraduatePerCapitaBorrowingAmount_option = {
            animation:false,
            backgroundColor:'white',
            tooltip: {
                trigger: 'axis',
            },
            legend: {
                data: ['人均册数', '全院系人均册数']
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis: {
                type: 'value',
                boundaryGap: [0, 0.01]
            },
            yAxis: {
                type: 'category',
                data: academy
            },
            series: [
                {
                    name: '人均册数',
                    type: 'bar',
                    data: reader_per_person
                },
                {
                    name: '全院系人均册数',
                    type: 'bar',
                    data: academy_per_person
                }
            ]
        };
        chartGetGraduatePerCapitaBorrowingAmount.setOption(chartGetGraduatePerCapitaBorrowingAmount_option);
    });
}

function getAnnualComparisonofBorrowings() {
    $.get('../../schoolReport/getUndergraduateAnnualComparisonofBorrowings', function (info) {
        var html = template('getAnnualComparisonofBorrowings',{param:info});
        $(".getUndergraduateAnnualComparisonofBorrowings").html(html);
        var tabledata = [];
        for(var i=0;i<info.length;i++){
            var tablebasedata = new Object();
            tablebasedata["19-1-1"] = info[i].year;
            tablebasedata["19-1-2"] = info[i].reader_number;
            tablebasedata["19-1-3"] = info[i].lend_number;
            tablebasedata["19-1-4"] = info[i].lend_total;
            tablebasedata["19-1-5"] = info[i].reader_per_person;
            tablebasedata["19-1-6"] = info[i].academy_per_person;
            tabledata.push(tablebasedata);
        }
        replace["getUndergraduateAnnualComparisonofBorrowings"] = tabledata;
    });
    $.get('../../schoolReport/getGraduateAnnualComparisonofBorrowings', function (info) {
        var html = template('getAnnualComparisonofBorrowings',{param:info});
        $(".getGraduateAnnualComparisonofBorrowings").html(html);
        var tabledata = [];
        for(var i=0;i<info.length;i++){
            var tablebasedata = new Object();
            tablebasedata["20-1-1"] = info[i].year;
            tablebasedata["20-1-2"] = info[i].reader_number;
            tablebasedata["20-1-3"] = info[i].lend_number;
            tablebasedata["20-1-4"] = info[i].lend_total;
            tablebasedata["20-1-5"] = info[i].reader_per_person;
            tablebasedata["20-1-6"] = info[i].academy_per_person;
            tabledata.push(tablebasedata);
        }
        replace["getGraduateAnnualComparisonofBorrowings"] = tabledata;
    });
}