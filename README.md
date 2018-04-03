<!DOCTYPE html>
<html class="" lang="en">
<head prefix="og: http://ogp.me/ns#">
<meta charset="utf-8">
<meta content="IE=edge" http-equiv="X-UA-Compatible">
<meta content="object" property="og:type">
<meta content="GitLab" property="og:site_name">
<meta content="README.md · 5ecaccf30e44b9a3d73a6442d847bdf3550404cf · Project Team S1-G / risk" property="og:title">
<meta content="CSSE376 project team S1-G&#39;s test driven implementation of Risk." property="og:description">
<meta content="https://ada.csse.rose-hulman.edu/assets/gitlab_logo-7ae504fe4f68fdebb3c2034e36621930cd36ea87924c11ff65dbcb8ed50dca58.png" property="og:image">
<meta content="64" property="og:image:width">
<meta content="64" property="og:image:height">
<meta content="https://ada.csse.rose-hulman.edu/csse376-s1-g/risk/blob/5ecaccf30e44b9a3d73a6442d847bdf3550404cf/README.md" property="og:url">
<meta content="summary" property="twitter:card">
<meta content="README.md · 5ecaccf30e44b9a3d73a6442d847bdf3550404cf · Project Team S1-G / risk" property="twitter:title">
<meta content="CSSE376 project team S1-G&#39;s test driven implementation of Risk." property="twitter:description">
<meta content="https://ada.csse.rose-hulman.edu/assets/gitlab_logo-7ae504fe4f68fdebb3c2034e36621930cd36ea87924c11ff65dbcb8ed50dca58.png" property="twitter:image">

<title>README.md · 5ecaccf30e44b9a3d73a6442d847bdf3550404cf · Project Team S1-G / risk · GitLab</title>
<meta content="CSSE376 project team S1-G&#39;s test driven implementation of Risk." name="description">
<link rel="shortcut icon" type="image/x-icon" href="/assets/favicon-075eba76312e8421991a0c1f89a89ee81678bcde72319dd3e8047e2a47cd3a42.ico" id="favicon" />
<link rel="stylesheet" media="all" href="/assets/application-8138c3e6d7ae415c96591b227125f4ec49d96a1eee15d0bdbe3c694a925bed68.css" />
<link rel="stylesheet" media="print" href="/assets/print-74b3d49adeaada27337e759b75a34af7cf3d80051de91d60d40570f5a382e132.css" />


<script>
//<![CDATA[
window.gon={};gon.api_version="v4";gon.default_avatar_url="https:\/\/ada.csse.rose-hulman.edu\/assets\/no_avatar-849f9c04a3a0d0cea2424ae97b27447dc64a7dbfae83c036c45b403392f0e8ba.png";gon.max_file_size=10;gon.asset_host=null;gon.webpack_public_path="\/assets\/webpack\/";gon.relative_url_root="";gon.shortcuts_path="\/help\/shortcuts";gon.user_color_scheme="white";gon.gitlab_url="https:\/\/ada.csse.rose-hulman.edu";gon.revision="8d768f9";gon.gitlab_logo="\/assets\/gitlab_logo-7ae504fe4f68fdebb3c2034e36621930cd36ea87924c11ff65dbcb8ed50dca58.png";gon.sprite_icons="\/assets\/icons-2666da8eb968ba69467c0369d020bf011a5d0b1bd253ba0dbcc43bd0ccbd0dcb.svg";gon.sprite_file_icons="\/assets\/file_icons-7262fc6897e02f1ceaf8de43dc33afa5e4f9a2067f4f68ef77dcc87946575e9e.svg";gon.current_user_id=609;gon.current_username="gearjt";gon.current_user_fullname="John T. Gear";gon.current_user_avatar_url="https:\/\/secure.gravatar.com\/avatar\/0df13edd61b9445bd1ca9661e7cfb252?s=80\u0026d=identicon";
//]]>
</script>

<script src="/assets/webpack/webpack_runtime.c82daa8ed45207cdb3e5.bundle.js" defer="defer"></script>
<script src="/assets/webpack/common.a0daec5c0ced839c326a.bundle.js" defer="defer"></script>
<script src="/assets/webpack/main.5dba62126422f14a195b.bundle.js" defer="defer"></script>


<script src="/assets/webpack/blob.90ab8a8567ea6525a06f.bundle.js" defer="defer"></script>
<script src="/assets/webpack/blob.90ab8a8567ea6525a06f.bundle.js" defer="defer"></script>


<script>
  window.uploads_path = "/csse376-s1-g/risk/uploads";
</script>

<meta name="csrf-param" content="authenticity_token" />
<meta name="csrf-token" content="7+t5zRoEQvOY8bdHcayvHwRy/A22ch8Cv2v3KfifhEcWqf4Zq61POWVCSIIzD/ukJy8Ty1UVyZkrdKym6vR6Xw==" />
<meta content="origin-when-cross-origin" name="referrer">
<meta content="width=device-width, initial-scale=1, maximum-scale=1" name="viewport">
<meta content="#474D57" name="theme-color">
<link rel="apple-touch-icon" type="image/x-icon" href="/assets/touch-icon-iphone-5a9cee0e8a51212e70b90c87c12f382c428870c0ff67d1eb034d884b78d2dae7.png" />
<link rel="apple-touch-icon" type="image/x-icon" href="/assets/touch-icon-ipad-a6eec6aeb9da138e507593b464fdac213047e49d3093fc30e90d9a995df83ba3.png" sizes="76x76" />
<link rel="apple-touch-icon" type="image/x-icon" href="/assets/touch-icon-iphone-retina-72e2aadf86513a56e050e7f0f2355deaa19cc17ed97bbe5147847f2748e5a3e3.png" sizes="120x120" />
<link rel="apple-touch-icon" type="image/x-icon" href="/assets/touch-icon-ipad-retina-8ebe416f5313483d9c1bc772b5bbe03ecad52a54eba443e5215a22caed2a16a2.png" sizes="152x152" />
<link color="rgb(226, 67, 41)" href="/assets/logo-d36b5212042cebc89b96df4bf6ac24e43db316143e89926c0db839ff694d2de4.svg" rel="mask-icon">
<meta content="/assets/msapplication-tile-1196ec67452f618d39cdd85e2e3a542f76574c071051ae7effbfde01710eb17d.png" name="msapplication-TileImage">
<meta content="#30353E" name="msapplication-TileColor">



</head>

<body class="ui_indigo " data-find-file="/csse376-s1-g/risk/find_file/5ecaccf30e44b9a3d73a6442d847bdf3550404cf" data-group="" data-page="projects:blob:show" data-project="risk">


<header class="navbar navbar-gitlab qa-navbar">
<a class="sr-only gl-accessibility" href="#content-body" tabindex="1">Skip to content</a>
<div class="container-fluid">
<div class="header-content">
<div class="title-container">
<h1 class="title">
<a title="Dashboard" id="logo" href="/"><img data-src="/uploads/-/system/appearance/header_logo/1/RoseLogo400x400.png" class=" lazy" src="data:image/gif;base64,R0lGODlhAQABAAAAACH5BAEKAAEALAAAAAABAAEAAAICTAEAOw==" />
</a></h1>
<ul class="list-unstyled navbar-sub-nav">
<li id="nav-projects-dropdown" class="home dropdown header-projects qa-projects-dropdown"><a data-toggle="dropdown" href="#">
Projects
<svg class=" caret-down"><use xlink:href="/assets/icons-2666da8eb968ba69467c0369d020bf011a5d0b1bd253ba0dbcc43bd0ccbd0dcb.svg#angle-down"></use></svg>
</a>
<div class="dropdown-menu projects-dropdown-menu">
<div class="projects-dropdown-container">
<div class="project-dropdown-sidebar qa-projects-dropdown-sidebar">
<ul>
<li class=""><a class="qa-your-projects-link" href="/dashboard/projects">Your projects
</a></li><li class=""><a href="/dashboard/projects/starred">Starred projects
</a></li><li class=""><a href="/explore">Explore projects
</a></li></ul>
</div>
<div class="project-dropdown-content">
<div data-project-id="3496" data-project-name="risk" data-project-namespace="Project Team S1-G / risk" data-project-web-url="/csse376-s1-g/risk" data-user-name="gearjt" id="js-projects-dropdown"></div>
</div>
</div>

</div>
</li><li class="hidden-xs"><a class="dashboard-shortcuts-groups qa-groups-link" title="Groups" href="/dashboard/groups">Groups
</a></li><li class="visible-lg"><a class="dashboard-shortcuts-activity" title="Activity" href="/dashboard/activity">Activity
</a></li><li class="visible-lg"><a class="dashboard-shortcuts-milestones" title="Milestones" href="/dashboard/milestones">Milestones
</a></li><li class="visible-lg"><a class="dashboard-shortcuts-snippets" title="Snippets" href="/dashboard/snippets">Snippets
</a></li><li class="header-more dropdown hidden-lg">
<a data-toggle="dropdown" href="#">
More
<svg class=" caret-down"><use xlink:href="/assets/icons-2666da8eb968ba69467c0369d020bf011a5d0b1bd253ba0dbcc43bd0ccbd0dcb.svg#angle-down"></use></svg>
</a>
<div class="dropdown-menu">
<ul>
<li class="visible-xs"><a class="dashboard-shortcuts-groups" title="Groups" href="/dashboard/groups">Groups
</a></li><li class=""><a title="Activity" href="/dashboard/activity">Activity
</a></li><li class=""><a class="dashboard-shortcuts-milestones" title="Milestones" href="/dashboard/milestones">Milestones
</a></li><li class=""><a class="dashboard-shortcuts-snippets" title="Snippets" href="/dashboard/snippets">Snippets
</a></li></ul>
</div>
</li>
<li class="hidden">
<a title="Projects" class="dashboard-shortcuts-projects" href="/dashboard/projects">Projects
</a></li>
</ul>

</div>
<div class="navbar-collapse collapse">
<ul class="nav navbar-nav">
<li class="header-new dropdown">
<a class="header-new-dropdown-toggle has-tooltip qa-new-menu-toggle" title="New..." ref="tooltip" aria-label="New..." data-toggle="dropdown" data-placement="bottom" data-container="body" href="/projects/new"><svg class="s16"><use xlink:href="/assets/icons-2666da8eb968ba69467c0369d020bf011a5d0b1bd253ba0dbcc43bd0ccbd0dcb.svg#plus-square"></use></svg>
<svg class=" caret-down"><use xlink:href="/assets/icons-2666da8eb968ba69467c0369d020bf011a5d0b1bd253ba0dbcc43bd0ccbd0dcb.svg#angle-down"></use></svg>
</a><div class="dropdown-menu-nav dropdown-menu-align-right">
<ul>
<li class="dropdown-bold-header">This project</li>
<li>
<a href="/csse376-s1-g/risk/issues/new">New issue</a>
</li>
<li>
<a href="/csse376-s1-g/risk/merge_requests/new">New merge request</a>
</li>
<li class="header-new-project-snippet">
<a href="/csse376-s1-g/risk/snippets/new">New snippet</a>
</li>
<li class="divider"></li>
<li class="dropdown-bold-header">GitLab</li>
<li>
<a href="/projects/new">New project</a>
</li>
<li>
<a href="/groups/new">New group</a>
</li>
<li>
<a href="/snippets/new">New snippet</a>
</li>
</ul>
</div>
</li>

<li class="hidden-sm hidden-xs">
<div class="has-location-badge search search-form">
<form class="navbar-form" action="/search" accept-charset="UTF-8" method="get"><input name="utf8" type="hidden" value="&#x2713;" /><div class="search-input-container">
<div class="location-badge">This project</div>
<div class="search-input-wrap">
<div class="dropdown" data-url="/search/autocomplete">
<input type="search" name="search" id="search" placeholder="Search" class="search-input dropdown-menu-toggle no-outline js-search-dashboard-options" spellcheck="false" tabindex="1" autocomplete="off" data-issues-path="/dashboard/issues" data-mr-path="/dashboard/merge_requests" aria-label="Search" />
<button class="hidden js-dropdown-search-toggle" data-toggle="dropdown" type="button"></button>
<div class="dropdown-menu dropdown-select">
<div class="dropdown-content"><ul>
<li class="dropdown-menu-empty-item">
<a>
Loading...
</a>
</li>
</ul>
</div><div class="dropdown-loading"><i aria-hidden="true" data-hidden="true" class="fa fa-spinner fa-spin"></i></div>
</div>
<svg class="s16 search-icon"><use xlink:href="/assets/icons-2666da8eb968ba69467c0369d020bf011a5d0b1bd253ba0dbcc43bd0ccbd0dcb.svg#search"></use></svg>
<svg class="s16 clear-icon js-clear-input"><use xlink:href="/assets/icons-2666da8eb968ba69467c0369d020bf011a5d0b1bd253ba0dbcc43bd0ccbd0dcb.svg#close"></use></svg>
</div>
</div>
</div>
<input type="hidden" name="group_id" id="group_id" class="js-search-group-options" />
<input type="hidden" name="project_id" id="search_project_id" value="3496" class="js-search-project-options" data-project-path="risk" data-name="risk" data-issues-path="/csse376-s1-g/risk/issues" data-mr-path="/csse376-s1-g/risk/merge_requests" data-issues-disabled="false" />
<input type="hidden" name="search_code" id="search_code" value="true" />
<input type="hidden" name="repository_ref" id="repository_ref" value="5ecaccf30e44b9a3d73a6442d847bdf3550404cf" />

<div class="search-autocomplete-opts hide" data-autocomplete-path="/search/autocomplete" data-autocomplete-project-id="3496" data-autocomplete-project-ref="5ecaccf30e44b9a3d73a6442d847bdf3550404cf"></div>
</form></div>

</li>
<li class="visible-sm-inline-block visible-xs-inline-block">
<a title="Search" aria-label="Search" data-toggle="tooltip" data-placement="bottom" data-container="body" href="/search"><svg class="s16"><use xlink:href="/assets/icons-2666da8eb968ba69467c0369d020bf011a5d0b1bd253ba0dbcc43bd0ccbd0dcb.svg#search"></use></svg>
</a></li>
<li class="user-counter"><a title="Issues" class="dashboard-shortcuts-issues" aria-label="Issues" data-toggle="tooltip" data-placement="bottom" data-container="body" href="/dashboard/issues?assignee_id=609"><svg class="s16"><use xlink:href="/assets/icons-2666da8eb968ba69467c0369d020bf011a5d0b1bd253ba0dbcc43bd0ccbd0dcb.svg#issues"></use></svg>
<span class="badge hidden issues-count">
0
</span>
</a></li><li class="user-counter"><a title="Merge requests" class="dashboard-shortcuts-merge_requests" aria-label="Merge requests" data-toggle="tooltip" data-placement="bottom" data-container="body" href="/dashboard/merge_requests?assignee_id=609"><svg class="s16"><use xlink:href="/assets/icons-2666da8eb968ba69467c0369d020bf011a5d0b1bd253ba0dbcc43bd0ccbd0dcb.svg#git-merge"></use></svg>
<span class="badge hidden merge-requests-count">
0
</span>
</a></li><li class="user-counter"><a title="Todos" aria-label="Todos" class="shortcuts-todos" data-toggle="tooltip" data-placement="bottom" data-container="body" href="/dashboard/todos"><svg class="s16"><use xlink:href="/assets/icons-2666da8eb968ba69467c0369d020bf011a5d0b1bd253ba0dbcc43bd0ccbd0dcb.svg#todo-done"></use></svg>
<span class="badge hidden todos-count">
0
</span>
</a></li><li class="header-user dropdown">
<a class="header-user-dropdown-toggle" data-toggle="dropdown" href="/gearjt"><img width="23" height="23" class="header-user-avatar qa-user-avatar lazy" data-src="https://secure.gravatar.com/avatar/0df13edd61b9445bd1ca9661e7cfb252?s=46&amp;d=identicon" src="data:image/gif;base64,R0lGODlhAQABAAAAACH5BAEKAAEALAAAAAABAAEAAAICTAEAOw==" />
<svg class=" caret-down"><use xlink:href="/assets/icons-2666da8eb968ba69467c0369d020bf011a5d0b1bd253ba0dbcc43bd0ccbd0dcb.svg#angle-down"></use></svg>
</a><div class="dropdown-menu-nav dropdown-menu-align-right">
<ul>
<li class="current-user">
<div class="user-name bold">
John T. Gear
</div>
@gearjt
</li>
<li class="divider"></li>
<li>
<a class="profile-link" data-user="gearjt" href="/gearjt">Profile</a>
</li>
<li>
<a href="/profile">Settings</a>
</li>
<li>
<a href="/help">Help</a>
</li>
<li class="divider"></li>
<li>
<a class="sign-out-link" href="/users/sign_out">Sign out</a>
</li>
</ul>
</div>
</li>
</ul>
</div>
<button class="navbar-toggle hidden-sm hidden-md hidden-lg" type="button">
<span class="sr-only">Toggle navigation</span>
<svg class="s12 more-icon js-navbar-toggle-right"><use xlink:href="/assets/icons-2666da8eb968ba69467c0369d020bf011a5d0b1bd253ba0dbcc43bd0ccbd0dcb.svg#more"></use></svg>
<svg class="s12 close-icon js-navbar-toggle-left"><use xlink:href="/assets/icons-2666da8eb968ba69467c0369d020bf011a5d0b1bd253ba0dbcc43bd0ccbd0dcb.svg#close"></use></svg>
</button>
</div>
</div>
</header>

<div class="layout-page page-with-contextual-sidebar">
<div class="nav-sidebar">
<div class="nav-sidebar-inner-scroll">
<div class="context-header">
<a title="risk" href="/csse376-s1-g/risk"><div class="avatar-container s40 project-avatar">
<div class="avatar s40 avatar-tile identicon" style="background-color: #E3F2FD; color: #555">R</div>
</div>
<div class="sidebar-context-title">
risk
</div>
</a></div>
<ul class="sidebar-top-level-items">
<li class="home"><a class="shortcuts-project" href="/csse376-s1-g/risk"><div class="nav-icon-container">
<svg><use xlink:href="/assets/icons-2666da8eb968ba69467c0369d020bf011a5d0b1bd253ba0dbcc43bd0ccbd0dcb.svg#project"></use></svg>
</div>
<span class="nav-item-name">
Overview
</span>
</a><ul class="sidebar-sub-level-items">
<li class="fly-out-top-item"><a href="/csse376-s1-g/risk"><strong class="fly-out-top-item-name">
Overview
</strong>
</a></li><li class="divider fly-out-top-item"></li>
<li class=""><a title="Project details" class="shortcuts-project" href="/csse376-s1-g/risk"><span>Details</span>
</a></li><li class=""><a title="Activity" class="shortcuts-project-activity" href="/csse376-s1-g/risk/activity"><span>Activity</span>
</a></li><li class=""><a title="Cycle Analytics" class="shortcuts-project-cycle-analytics" href="/csse376-s1-g/risk/cycle_analytics"><span>Cycle Analytics</span>
</a></li></ul>
</li><li class="active"><a class="shortcuts-tree" href="/csse376-s1-g/risk/tree/5ecaccf30e44b9a3d73a6442d847bdf3550404cf"><div class="nav-icon-container">
<svg><use xlink:href="/assets/icons-2666da8eb968ba69467c0369d020bf011a5d0b1bd253ba0dbcc43bd0ccbd0dcb.svg#doc_text"></use></svg>
</div>
<span class="nav-item-name">
Repository
</span>
</a><ul class="sidebar-sub-level-items">
<li class="fly-out-top-item active"><a href="/csse376-s1-g/risk/tree/5ecaccf30e44b9a3d73a6442d847bdf3550404cf"><strong class="fly-out-top-item-name">
Repository
</strong>
</a></li><li class="divider fly-out-top-item"></li>
<li class="active"><a href="/csse376-s1-g/risk/tree/5ecaccf30e44b9a3d73a6442d847bdf3550404cf">Files
</a></li><li class=""><a href="/csse376-s1-g/risk/commits/5ecaccf30e44b9a3d73a6442d847bdf3550404cf">Commits
</a></li><li class=""><a href="/csse376-s1-g/risk/branches">Branches
</a></li><li class=""><a href="/csse376-s1-g/risk/tags">Tags
</a></li><li class=""><a href="/csse376-s1-g/risk/graphs/5ecaccf30e44b9a3d73a6442d847bdf3550404cf">Contributors
</a></li><li class=""><a href="/csse376-s1-g/risk/network/5ecaccf30e44b9a3d73a6442d847bdf3550404cf">Graph
</a></li><li class=""><a href="/csse376-s1-g/risk/compare?from=master&amp;to=5ecaccf30e44b9a3d73a6442d847bdf3550404cf">Compare
</a></li><li class=""><a href="/csse376-s1-g/risk/graphs/5ecaccf30e44b9a3d73a6442d847bdf3550404cf/charts">Charts
</a></li></ul>
</li><li class=""><a class="shortcuts-container-registry" href="/csse376-s1-g/risk/container_registry"><div class="nav-icon-container">
<svg><use xlink:href="/assets/icons-2666da8eb968ba69467c0369d020bf011a5d0b1bd253ba0dbcc43bd0ccbd0dcb.svg#disk"></use></svg>
</div>
<span class="nav-item-name">
Registry
</span>
</a></li><li class=""><a class="shortcuts-issues" href="/csse376-s1-g/risk/issues"><div class="nav-icon-container">
<svg><use xlink:href="/assets/icons-2666da8eb968ba69467c0369d020bf011a5d0b1bd253ba0dbcc43bd0ccbd0dcb.svg#issues"></use></svg>
</div>
<span class="nav-item-name">
Issues
</span>
<span class="badge count issue_counter">
0
</span>
</a><ul class="sidebar-sub-level-items">
<li class="fly-out-top-item"><a href="/csse376-s1-g/risk/issues"><strong class="fly-out-top-item-name">
Issues
</strong>
<span class="badge count issue_counter fly-out-badge">
0
</span>
</a></li><li class="divider fly-out-top-item"></li>
<li class=""><a title="Issues" href="/csse376-s1-g/risk/issues"><span>
List
</span>
</a></li><li class=""><a title="Board" href="/csse376-s1-g/risk/boards"><span>
Board
</span>
</a></li><li class=""><a title="Labels" href="/csse376-s1-g/risk/labels"><span>
Labels
</span>
</a></li><li class=""><a title="Milestones" href="/csse376-s1-g/risk/milestones"><span>
Milestones
</span>
</a></li></ul>
</li><li class=""><a class="shortcuts-merge_requests" href="/csse376-s1-g/risk/merge_requests"><div class="nav-icon-container">
<svg><use xlink:href="/assets/icons-2666da8eb968ba69467c0369d020bf011a5d0b1bd253ba0dbcc43bd0ccbd0dcb.svg#git-merge"></use></svg>
</div>
<span class="nav-item-name">
Merge Requests
</span>
<span class="badge count merge_counter js-merge-counter">
0
</span>
</a><ul class="sidebar-sub-level-items is-fly-out-only">
<li class="fly-out-top-item"><a href="/csse376-s1-g/risk/merge_requests"><strong class="fly-out-top-item-name">
Merge Requests
</strong>
<span class="badge count merge_counter js-merge-counter fly-out-badge">
0
</span>
</a></li></ul>
</li><li class=""><a class="shortcuts-pipelines" href="/csse376-s1-g/risk/pipelines"><div class="nav-icon-container">
<svg><use xlink:href="/assets/icons-2666da8eb968ba69467c0369d020bf011a5d0b1bd253ba0dbcc43bd0ccbd0dcb.svg#pipeline"></use></svg>
</div>
<span class="nav-item-name">
CI / CD
</span>
</a><ul class="sidebar-sub-level-items">
<li class="fly-out-top-item"><a href="/csse376-s1-g/risk/pipelines"><strong class="fly-out-top-item-name">
CI / CD
</strong>
</a></li><li class="divider fly-out-top-item"></li>
<li class=""><a title="Pipelines" class="shortcuts-pipelines" href="/csse376-s1-g/risk/pipelines"><span>
Pipelines
</span>
</a></li><li class=""><a title="Jobs" class="shortcuts-builds" href="/csse376-s1-g/risk/-/jobs"><span>
Jobs
</span>
</a></li><li class=""><a title="Schedules" class="shortcuts-builds" href="/csse376-s1-g/risk/pipeline_schedules"><span>
Schedules
</span>
</a></li><li class=""><a title="Environments" class="shortcuts-environments" href="/csse376-s1-g/risk/environments"><span>
Environments
</span>
</a></li><li class=""><a title="Kubernetes" class="shortcuts-cluster" href="/csse376-s1-g/risk/clusters"><span>
Kubernetes
</span>
<div class="feature-highlight js-feature-highlight" data-container="body" data-dismiss-endpoint="/-/user_callouts" data-highlight="gke_cluster_integration" data-placement="right" data-toggle="popover" data-trigger="manual" disabled></div>
</a><div class="feature-highlight-popover-content">
<img class="feature-highlight-illustration lazy" data-src="/assets/illustrations/cluster_popover-9830388038d966d8d64d43576808f9d5ba05f639a78a40bae9a5ddc7cbf72f24.svg" src="data:image/gif;base64,R0lGODlhAQABAAAAACH5BAEKAAEALAAAAAABAAEAAAICTAEAOw==" />
<div class="feature-highlight-popover-sub-content">
<p>Allows you to add and manage Kubernetes clusters.</p>
<p>
Protip:
<a href="/help/topics/autodevops/index.md">Auto DevOps</a>
<span>uses Kubernetes clusters to deploy your code!</span>
</p>
<hr>
<button class="btn btn-create btn-xs dismiss-feature-highlight" type="button">
<span>Got it!</span>
<svg><use xlink:href="/assets/icons-2666da8eb968ba69467c0369d020bf011a5d0b1bd253ba0dbcc43bd0ccbd0dcb.svg#thumb-up"></use></svg>
</button>
</div>
</div>
</li><li class=""><a title="Charts" class="shortcuts-pipelines-charts" href="/csse376-s1-g/risk/pipelines/charts"><span>
Charts
</span>
</a></li></ul>
</li><li class=""><a class="shortcuts-wiki" href="/csse376-s1-g/risk/wikis/home"><div class="nav-icon-container">
<svg><use xlink:href="/assets/icons-2666da8eb968ba69467c0369d020bf011a5d0b1bd253ba0dbcc43bd0ccbd0dcb.svg#book"></use></svg>
</div>
<span class="nav-item-name">
Wiki
</span>
</a><ul class="sidebar-sub-level-items is-fly-out-only">
<li class="fly-out-top-item"><a href="/csse376-s1-g/risk/wikis/home"><strong class="fly-out-top-item-name">
Wiki
</strong>
</a></li></ul>
</li><li class=""><a class="shortcuts-snippets" href="/csse376-s1-g/risk/snippets"><div class="nav-icon-container">
<svg><use xlink:href="/assets/icons-2666da8eb968ba69467c0369d020bf011a5d0b1bd253ba0dbcc43bd0ccbd0dcb.svg#snippet"></use></svg>
</div>
<span class="nav-item-name">
Snippets
</span>
</a><ul class="sidebar-sub-level-items is-fly-out-only">
<li class="fly-out-top-item"><a href="/csse376-s1-g/risk/snippets"><strong class="fly-out-top-item-name">
Snippets
</strong>
</a></li></ul>
</li><li class=""><a class="shortcuts-tree" href="/csse376-s1-g/risk/edit"><div class="nav-icon-container">
<svg><use xlink:href="/assets/icons-2666da8eb968ba69467c0369d020bf011a5d0b1bd253ba0dbcc43bd0ccbd0dcb.svg#settings"></use></svg>
</div>
<span class="nav-item-name qa-settings-item">
Settings
</span>
</a><ul class="sidebar-sub-level-items">
<li class="fly-out-top-item"><a href="/csse376-s1-g/risk/edit"><strong class="fly-out-top-item-name">
Settings
</strong>
</a></li><li class="divider fly-out-top-item"></li>
<li class=""><a title="General" href="/csse376-s1-g/risk/edit"><span>
General
</span>
</a></li><li class=""><a title="Members" href="/csse376-s1-g/risk/project_members"><span>
Members
</span>
</a></li><li class=""><a title="Integrations" href="/csse376-s1-g/risk/settings/integrations"><span>
Integrations
</span>
</a></li><li class=""><a title="Repository" href="/csse376-s1-g/risk/settings/repository"><span>
Repository
</span>
</a></li><li class=""><a title="CI / CD" href="/csse376-s1-g/risk/settings/ci_cd"><span>
CI / CD
</span>
</a></li></ul>
</li><a class="toggle-sidebar-button js-toggle-sidebar" role="button" title="Toggle sidebar" type="button">
<svg class=" icon-angle-double-left"><use xlink:href="/assets/icons-2666da8eb968ba69467c0369d020bf011a5d0b1bd253ba0dbcc43bd0ccbd0dcb.svg#angle-double-left"></use></svg>
<svg class=" icon-angle-double-right"><use xlink:href="/assets/icons-2666da8eb968ba69467c0369d020bf011a5d0b1bd253ba0dbcc43bd0ccbd0dcb.svg#angle-double-right"></use></svg>
<span class="collapse-text">Collapse sidebar</span>
</a>
<button name="button" type="button" class="close-nav-button"><svg class="s16"><use xlink:href="/assets/icons-2666da8eb968ba69467c0369d020bf011a5d0b1bd253ba0dbcc43bd0ccbd0dcb.svg#close"></use></svg>
<span class="collapse-text">Close sidebar</span>
</button>
<li class="hidden">
<a title="Activity" class="shortcuts-project-activity" href="/csse376-s1-g/risk/activity"><span>
Activity
</span>
</a></li>
<li class="hidden">
<a title="Network" class="shortcuts-network" href="/csse376-s1-g/risk/network/5ecaccf30e44b9a3d73a6442d847bdf3550404cf">Graph
</a></li>
<li class="hidden">
<a title="Charts" class="shortcuts-repository-charts" href="/csse376-s1-g/risk/graphs/5ecaccf30e44b9a3d73a6442d847bdf3550404cf/charts">Charts
</a></li>
<li class="hidden">
<a class="shortcuts-new-issue" href="/csse376-s1-g/risk/issues/new">Create a new issue
</a></li>
<li class="hidden">
<a title="Jobs" class="shortcuts-builds" href="/csse376-s1-g/risk/-/jobs">Jobs
</a></li>
<li class="hidden">
<a title="Commits" class="shortcuts-commits" href="/csse376-s1-g/risk/commits/5ecaccf30e44b9a3d73a6442d847bdf3550404cf">Commits
</a></li>
<li class="hidden">
<a title="Issue Boards" class="shortcuts-issue-boards" href="/csse376-s1-g/risk/boards">Issue Boards</a>
</li>
</ul>
</div>
</div>

<div class="content-wrapper">

<div class="mobile-overlay"></div>
<div class="alert-wrapper">


<nav class="breadcrumbs container-fluid container-limited" role="navigation">
<div class="breadcrumbs-container">
<button name="button" type="button" class="toggle-mobile-nav"><span class="sr-only">Open sidebar</span>
<i aria-hidden="true" data-hidden="true" class="fa fa-bars"></i>
</button><div class="breadcrumbs-links js-title-container">
<ul class="list-unstyled breadcrumbs-list js-breadcrumbs-list">
<li><a class="group-path breadcrumb-item-text js-breadcrumb-item-text " href="/csse376-s1-g">Project Team S1-G</a><svg class="s8 breadcrumbs-list-angle"><use xlink:href="/assets/icons-2666da8eb968ba69467c0369d020bf011a5d0b1bd253ba0dbcc43bd0ccbd0dcb.svg#angle-right"></use></svg></li> <li><a href="/csse376-s1-g/risk"><span class="breadcrumb-item-text js-breadcrumb-item-text">risk</span></a><svg class="s8 breadcrumbs-list-angle"><use xlink:href="/assets/icons-2666da8eb968ba69467c0369d020bf011a5d0b1bd253ba0dbcc43bd0ccbd0dcb.svg#angle-right"></use></svg></li>

<li>
<h2 class="breadcrumbs-sub-title"><a href="/csse376-s1-g/risk/blob/5ecaccf30e44b9a3d73a6442d847bdf3550404cf/README.md">Repository</a></h2>
</li>
</ul>
</div>

</div>
</nav>

<div class="flash-container flash-container-page">
</div>

</div>
<div class=" ">
<div class="content" id="content-body">
<div class="container-fluid container-limited">

<div class="tree-holder" id="tree-holder">
<div class="nav-block">
<div class="tree-ref-container">
<div class="tree-ref-holder">
<form class="project-refs-form" action="/csse376-s1-g/risk/refs/switch" accept-charset="UTF-8" method="get"><input name="utf8" type="hidden" value="&#x2713;" /><input type="hidden" name="destination" id="destination" value="blob" />
<input type="hidden" name="path" id="path" value="README.md" />
<div class="dropdown">
<button class="dropdown-menu-toggle js-project-refs-dropdown" type="button" data-toggle="dropdown" data-selected="5ecaccf30e44b9a3d73a6442d847bdf3550404cf" data-ref="5ecaccf30e44b9a3d73a6442d847bdf3550404cf" data-refs-url="/csse376-s1-g/risk/refs?sort=updated_desc" data-field-name="ref" data-submit-form-on-click="true" data-visit="true"><span class="dropdown-toggle-text ">5ecaccf30e44b9a3d73a6442d847bdf3550404cf</span><i aria-hidden="true" data-hidden="true" class="fa fa-chevron-down"></i></button>
<div class="dropdown-menu dropdown-menu-paging dropdown-menu-selectable git-revision-dropdown">
<div class="dropdown-page-one">
<div class="dropdown-title"><span>Switch branch/tag</span><button class="dropdown-title-button dropdown-menu-close" aria-label="Close" type="button"><i aria-hidden="true" data-hidden="true" class="fa fa-times dropdown-menu-close-icon"></i></button></div>
<div class="dropdown-input"><input type="search" id="" class="dropdown-input-field" placeholder="Search branches and tags" autocomplete="off" /><i aria-hidden="true" data-hidden="true" class="fa fa-search dropdown-input-search"></i><i role="button" aria-hidden="true" data-hidden="true" class="fa fa-times dropdown-input-clear js-dropdown-input-clear"></i></div>
<div class="dropdown-content"></div>
<div class="dropdown-loading"><i aria-hidden="true" data-hidden="true" class="fa fa-spinner fa-spin"></i></div>
</div>
</div>
</div>
</form>
</div>
<ul class="breadcrumb repo-breadcrumb">
<li>
<a href="/csse376-s1-g/risk/tree/5ecaccf30e44b9a3d73a6442d847bdf3550404cf">risk
</a></li>
<li>
<a href="/csse376-s1-g/risk/blob/5ecaccf30e44b9a3d73a6442d847bdf3550404cf/README.md"><strong>README.md</strong>
</a></li>
</ul>
</div>
<div class="tree-controls">
<a class="btn shortcuts-find-file" rel="nofollow" href="/csse376-s1-g/risk/find_file/5ecaccf30e44b9a3d73a6442d847bdf3550404cf"><i aria-hidden="true" data-hidden="true" class="fa fa-search"></i>
<span>Find file</span>
</a>
<div class="btn-group" role="group"><a class="btn js-blob-blame-link" href="/csse376-s1-g/risk/blame/5ecaccf30e44b9a3d73a6442d847bdf3550404cf/README.md">Blame</a><a class="btn" href="/csse376-s1-g/risk/commits/5ecaccf30e44b9a3d73a6442d847bdf3550404cf/README.md">History</a><a class="btn js-data-file-blob-permalink-url" href="/csse376-s1-g/risk/blob/5ecaccf30e44b9a3d73a6442d847bdf3550404cf/README.md">Permalink</a></div>
</div>
</div>

<div class="info-well hidden-xs">
<div class="well-segment">
<ul class="blob-commit-info">
<li class="commit flex-row js-toggle-container" id="commit-d598d20a">
<div class="avatar-cell hidden-xs">
<a href="/schaffqg"><img alt="Quinn G Schaffer&#39;s avatar" src="https://secure.gravatar.com/avatar/dca7b227edf05cb34a13371cec651f9e?s=72&amp;d=identicon" data-container="body" class="avatar s36 hidden-xs has-tooltip" title="Quinn G Schaffer" /></a>
</div>
<div class="commit-detail">
<div class="commit-content">
<a class="commit-row-message item-title" href="/csse376-s1-g/risk/commit/d598d20ae3feb7c750644a6e5da1e6fa01b7a781">Update README.md</a>
<span class="commit-row-message visible-xs-inline">
&middot;
d598d20a
</span>
<div class="commiter">
<a class="commit-author-link has-tooltip" title="schaffqg@rose-hulman.edu" href="/schaffqg">Quinn G Schaffer</a> authored <time class="js-timeago" title="Apr 3, 2018 12:53pm" datetime="2018-04-03T17:53:38Z" data-toggle="tooltip" data-placement="bottom" data-container="body">Apr 03, 2018</time>
</div>
</div>
<div class="commit-actions flex-row hidden-xs">

<div class="js-commit-pipeline-status" data-endpoint="/csse376-s1-g/risk/commit/d598d20ae3feb7c750644a6e5da1e6fa01b7a781/pipelines"></div>
<a class="commit-sha btn btn-transparent btn-link" href="/csse376-s1-g/risk/commit/d598d20ae3feb7c750644a6e5da1e6fa01b7a781">d598d20a</a>
<button class="btn btn-clipboard btn-transparent" data-toggle="tooltip" data-placement="bottom" data-container="body" data-title="Copy commit SHA to clipboard" data-clipboard-text="d598d20ae3feb7c750644a6e5da1e6fa01b7a781" type="button" title="Copy commit SHA to clipboard" aria-label="Copy commit SHA to clipboard"><i aria-hidden="true" aria-hidden="true" data-hidden="true" class="fa fa-clipboard"></i></button>

</div>
</div>
</li>

</ul>
</div>

</div>
<div class="blob-content-holder" id="blob-content-holder">
<article class="file-holder">
<div class="js-file-title file-title-flex-parent">
<div class="file-header-content">
<i aria-hidden="true" data-hidden="true" class="fa fa-file-text-o fa-fw"></i>
<strong class="file-title-name">
README.md
</strong>
<button class="btn btn-clipboard btn-transparent prepend-left-5" data-toggle="tooltip" data-placement="bottom" data-container="body" data-class="btn-clipboard btn-transparent prepend-left-5" data-title="Copy file path to clipboard" data-clipboard-text="{&quot;text&quot;:&quot;README.md&quot;,&quot;gfm&quot;:&quot;`README.md`&quot;}" type="button" title="Copy file path to clipboard" aria-label="Copy file path to clipboard"><i aria-hidden="true" aria-hidden="true" data-hidden="true" class="fa fa-clipboard"></i></button>
<small>
8.13 KB
</small>
</div>

<div class="file-actions">
<div class="btn-group js-blob-viewer-switcher" role="group">
<button aria-label="Display source" class="btn btn-default btn-sm js-blob-viewer-switch-btn has-tooltip" data-container="body" data-viewer="simple" title="Display source">
<i aria-hidden="true" data-hidden="true" class="fa fa-code"></i>
</button><button aria-label="Display rendered file" class="btn btn-default btn-sm js-blob-viewer-switch-btn has-tooltip" data-container="body" data-viewer="rich" title="Display rendered file">
<i aria-hidden="true" data-hidden="true" class="fa fa-file-text-o"></i>
</button></div>

<div class="btn-group" role="group"><button class="btn btn btn-sm js-copy-blob-source-btn" data-toggle="tooltip" data-placement="bottom" data-container="body" data-class="btn btn-sm js-copy-blob-source-btn" data-title="Copy source to clipboard" data-clipboard-target=".blob-content[data-blob-id=&#39;57a7b4e4824e934d5dc0ae9eec5b7e96823c2283&#39;]" type="button" title="Copy source to clipboard" aria-label="Copy source to clipboard"><i aria-hidden="true" aria-hidden="true" data-hidden="true" class="fa fa-clipboard"></i></button><a class="btn btn-sm has-tooltip" target="_blank" rel="noopener noreferrer" title="Open raw" data-container="body" href="/csse376-s1-g/risk/raw/5ecaccf30e44b9a3d73a6442d847bdf3550404cf/README.md"><i aria-hidden="true" data-hidden="true" class="fa fa-file-code-o"></i></a></div>
<div class="btn-group" role="group"><button name="button" type="submit" class="btn js-edit-blob  disabled has-tooltip" title="You can only edit files when you are on a branch" data-container="body">Edit</button><button name="button" type="submit" class="btn btn-default disabled has-tooltip" title="You can only replace files when you are on a branch" data-container="body">Replace</button><button name="button" type="submit" class="btn btn-remove disabled has-tooltip" title="You can only delete files when you are on a branch" data-container="body">Delete</button></div>
</div>
</div>
<div class="js-file-fork-suggestion-section file-fork-suggestion hidden">
<span class="file-fork-suggestion-note">
You're not allowed to
<span class="js-file-fork-suggestion-section-action">
edit
</span>
files in this project directly. Please fork this project,
make your changes there, and submit a merge request.
</span>
<a class="js-fork-suggestion-button btn btn-grouped btn-inverted btn-new" rel="nofollow" data-method="post" href="/csse376-s1-g/risk/blob/5ecaccf30e44b9a3d73a6442d847bdf3550404cf/README.md">Fork</a>
<button class="js-cancel-fork-suggestion-button btn btn-grouped" type="button">
Cancel
</button>
</div>


<div class="blob-viewer hidden" data-type="simple" data-url="/csse376-s1-g/risk/blob/5ecaccf30e44b9a3d73a6442d847bdf3550404cf/README.md?format=json&amp;viewer=simple">
<div class="text-center prepend-top-default append-bottom-default">
<i aria-hidden="true" aria-label="Loading content…" class="fa fa-spinner fa-spin fa-2x"></i>
</div>

</div>

<div class="blob-viewer" data-type="rich" data-url="/csse376-s1-g/risk/blob/5ecaccf30e44b9a3d73a6442d847bdf3550404cf/README.md?format=json&amp;viewer=rich">
<div class="text-center prepend-top-default append-bottom-default">
<i aria-hidden="true" aria-label="Loading content…" class="fa fa-spinner fa-spin fa-2x"></i>
</div>

</div>


</article>
</div>

<div class="modal" id="modal-upload-blob">
<div class="modal-dialog modal-lg">
<div class="modal-content">
<div class="modal-header">
<a class="close" data-dismiss="modal" href="#">×</a>
<h3 class="page-title">Replace README.md</h3>
</div>
<div class="modal-body">
<form class="js-quick-submit js-upload-blob-form form-horizontal" data-method="put" action="/csse376-s1-g/risk/update/5ecaccf30e44b9a3d73a6442d847bdf3550404cf/README.md" accept-charset="UTF-8" method="post"><input name="utf8" type="hidden" value="&#x2713;" /><input type="hidden" name="_method" value="put" /><input type="hidden" name="authenticity_token" value="hG2nE9xRJLkrDn7kRhMdoRZP1eaAMFeGogN1pZ/tyRJ9LyDHbfgpc9a9gSEEsEkaNRI6IGNXgR02HC4qjYY3Cg==" /><div class="dropzone">
<div class="dropzone-previews blob-upload-dropzone-previews">
<p class="dz-message light">
Attach a file by drag &amp; drop or <a class="markdown-selector" href="#">click to upload</a>
</p>
</div>
</div>
<br>
<div class="dropzone-alerts alert alert-danger data" style="display:none"></div>
<div class="form-group commit_message-group">
<label class="control-label" for="commit_message-56c965c57bd1bca9addcb2e4d8bc1bcd">Commit message
</label><div class="col-sm-10">
<div class="commit-message-container">
<div class="max-width-marker"></div>
<textarea name="commit_message" id="commit_message-56c965c57bd1bca9addcb2e4d8bc1bcd" class="form-control js-commit-message" placeholder="Replace README.md" required="required" rows="3">
Replace README.md</textarea>
</div>
</div>
</div>

<div class="form-group branch">
<label class="control-label" for="branch_name">Target Branch</label>
<div class="col-sm-10">
<input type="text" name="branch_name" id="branch_name" required="required" class="form-control js-branch-name ref-name" />
<div class="js-create-merge-request-container">
<div class="checkbox">
<label for="create_merge_request-eb1b5ff25c92c8fa416ec7db8937a693"><input type="checkbox" name="create_merge_request" id="create_merge_request-eb1b5ff25c92c8fa416ec7db8937a693" value="1" class="js-create-merge-request" checked="checked" />
Start a <strong>new merge request</strong> with these changes
</label></div>

</div>
</div>
</div>
<input type="hidden" name="original_branch" id="original_branch" value="5ecaccf30e44b9a3d73a6442d847bdf3550404cf" class="js-original-branch" />

<div class="form-actions">
<button name="button" type="button" class="btn btn-create btn-upload-file" id="submit-all"><i aria-hidden="true" data-hidden="true" class="fa fa-spin fa-spinner js-loading-icon hidden"></i>
Replace file
</button><a class="btn btn-cancel" data-dismiss="modal" href="#">Cancel</a>
</div>
</form></div>
</div>
</div>
</div>

</div>
</div>

</div>
</div>
</div>
</div>


</body>
</html>

