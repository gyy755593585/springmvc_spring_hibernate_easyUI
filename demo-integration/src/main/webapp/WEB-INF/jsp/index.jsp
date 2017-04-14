<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<script type="text/javascript">
    var index_layout;
    var index_tabs;
    var index_tabsMenu;
    var layout_west_tree_saleCost;
    var layout_west_tree_baobiao;
    var layout_west_tree_dingdan;
    $(function() {
        index_layout = $('#index_layout').layout({
            fit : true
        });

        index_tabs = $('#index_tabs').tabs({
            fit : true,
            border : false,
            tools : [{
                iconCls : 'icon-home',
                handler : function() {
                    index_tabs.tabs('select', 0);
                }
            }, {
                iconCls : 'icon-refresh',
                handler : function() {
                    var index = index_tabs.tabs('getTabIndex', index_tabs.tabs('getSelected'));
                    index_tabs.tabs('getTab', index).panel('open').panel('refresh');
                }
            }, {
                iconCls : 'icon-del',
                handler : function() {
                    var index = index_tabs.tabs('getTabIndex', index_tabs.tabs('getSelected'));
                    var tab = index_tabs.tabs('getTab', index);
                    if (tab.panel('options').closable) {
                        index_tabs.tabs('close', index);
                    }
                }
            } ]
        });
        layout_west_tree_saleCost = $('#layout_west_tree_saleCost').tree({
        	data: [
        	       {id:'1',text: '用户列表',attributes:'/user'}],
                    parentField : 0,
            lines : false,
            onClick : function(node) {
                if (node.attributes.indexOf("http") >= 0) {
                    var url = node.attributes;
                    addTab({
                        url : url,
                        title : node.text,
                        iconCls : node.iconCls
                    });
                } else if (node.attributes) {
                    var url = '${path }' + node.attributes;
                    addTab({
                        url : url,
                        title : node.text,
                        iconCls : node.iconCls
                    });
                }
            }
        });
        layout_west_tree_baobiao = $('#layout_west_tree_baobiao').tree({
        	data: [
        	       {id:'4',text: 'oooo',attributes:'/'}],
                    parentField : 0,
            lines : false,
            onClick : function(node) {
                if (node.attributes.indexOf("http") >= 0) {
                    var url = node.attributes;
                    addTab({
                        url : url,
                        title : node.text,
                        iconCls : node.iconCls
                    });
                } else if (node.attributes) {
                    var url = '${path }' + node.attributes;
                    addTab({
                        url : url,
                        title : node.text,
                        iconCls : node.iconCls
                    });
                }
            }
        });
        layout_west_tree_dingdan = $('#layout_west_tree_dingdan').tree({
        	data: [
        	        {id:'3',text: '详情',attributes:'/'}],
                    parentField : 0,
            lines : false,
            onClick : function(node) {
                if (node.attributes.indexOf("http") >= 0) {
                    var url = node.attributes;
                    addTab({
                        url : url,
                        title : node.text,
                        iconCls : node.iconCls
                    });
                } else if (node.attributes) {
                    var url = '${path }' + node.attributes;
                    addTab({
                        url : url,
                        title : node.text,
                        iconCls : node.iconCls
                    });
                }
            }
        });
            
    });

    function addTab(params) {
        var iframe = '<iframe src="' + params.url + '" frameborder="0" style="border:0;width:100%;height:99.5%;"></iframe>';
        var t = $('#index_tabs');
        var opts = {
            title : params.title,
            closable : true,
            iconCls : params.iconCls,
            content : iframe,
            border : false,
            fit : true
        };
        if (t.tabs('exists', opts.title)) {
            t.tabs('select', opts.title);
        } else {
            t.tabs('add', opts);
        }
    }


</script>
</head>
<body>
	<div id="loading"
		style="position: fixed; top: -50%; left: -50%; width: 200%; height: 200%; background: #fff; z-index: 100; overflow: hidden;">
		<img src="${staticPath }/static/style/images/ajax-loader.gif"
			style="position: absolute; top: 0; left: 0; right: 0; bottom: 0; margin: auto;" />
	</div>
	<div id="index_layout">
		<div data-options="region:'north',border:false"
			style="overflow: hidden;">
			<div>
				
			</div>
		</div>
		<div data-options="region:'west',split:true" title="导航栏"
			style="width: 200px; overflow: hidden; overflow-y: auto; padding: 0px">
			<div id="menu" class="easyui-accordion" fit="true" border="false">
				<div title="导航栏" data-options="iconCls:'icon-search',selected:true"
					style="overflow: auto; padding: 10px;">
					<ul id="layout_west_tree_saleCost"></ul>
				</div>
				<div title="导航栏" data-options="iconCls:'icon-search'"
					style="padding: 10px;">
					<ul id="layout_west_tree_baobiao"></ul>
				</div>
				<div title="导航栏" data-options="iconCls:'icon-search'"
					style="overflow: auto; padding: 10px;">
					<ul id="layout_west_tree_dingdan"></ul>
				</div>
			</div>
		</div>
		<div data-options="region:'center'" style="overflow: hidden;">
			<div id="index_tabs" style="overflow: hidden;">
				<div title="首页" data-options="border:false"
					style="overflow: hidden;">	
             <img src="${staticPath }/static/style/images/welcome.png"
			style="margin: auto;" />
					</div>
			</div>
		</div>
		<div data-options="region:'south',border:false"
			style="height: 30px; line-height: 30px; overflow: hidden; text-align: center; background-color: #eee">
			Copyright © 2017 power by <a href="#" target="_blank">无极</a>
		</div>
	</div>


	<style>
/*ie6提示*/
#ie6-warning {
	width: 100%;
	position: absolute;
	top: 0;
	left: 0;
	background: #fae692;
	padding: 5px 0;
	font-size: 12px
}

#ie6-warning p {
	width: 960px;
	margin: 0 auto;
}
</style>
</body>
</html>