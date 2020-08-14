<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="snack.helper.WebHelper" %>
<%
    String rootURL = WebHelper.getRootURL(request);
%>
<footer class="page-footer font-small blue-grey lighten-5 mt-5">
    <div style="background-color: #fff09f;">
        <div class="container">
            <div class="row py-4 d-flex align-items-center">
                <div class="col-md-6 col-lg-5 text-center text-md-left mb-4 mb-md-0">
                    <h6 class="mb-0">最新情報や割引クーポンなどSNSで配布中！</h6>
                </div>

                <div class="col-md-6 col-lg-7 text-center text-md-right">
                    <a class="fb-ic">
                        <i class="fab fa-facebook-f white-text mr-4"> </i>
                    </a>
                    <a class="tw-ic">
                        <i class="fab fa-twitter white-text mr-4"> </i>
                    </a>
                    <a class="gplus-ic">
                        <i class="fab fa-google-plus-g white-text mr-4"> </i>
                    </a>
                    <a class="li-ic">
                        <i class="fab fa-linkedin-in white-text mr-4"> </i>
                    </a>
                    <a class="ins-ic">
                        <i class="fab fa-instagram white-text"> </i>
                    </a>
                </div>
            </div>
        </div>
    </div>

    <div class="container text-center text-md-left mt-5">
        <div class="row mt-3 dark-grey-text">
            <div class="col-md-3 col-lg-4 col-xl-3 mb-4">
                <h6 class="font-weight-bold">Sweeter</h6>
                <hr class="teal accent-3 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                <p>
                    懐かしいお菓子から今どきのお菓子までいろんなお菓子を1コから購入することができます！
                </p>
            </div>

            <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
                <h6 class="font-weight-bold">ログイン</h6>
                <hr class="teal accent-3 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                <p>
                    <a class="dark-grey-text" href="<%= rootURL %>/login">ログイン</a>
                </p>
                <p>
                    <a class="dark-grey-text" href="<%= rootURL %>/admin/login">管理者ログイン</a>
                </p>
            </div>

            <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
                <h6 class="font-weight-bold">リンク</h6>
                <hr class="teal accent-3 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                <p>
                    <a class="dark-grey-text" href="<%= rootURL %>/news/list">お知らせ</a>
                </p>
                <p>
                    <a class="dark-grey-text" href="#!">Help</a>
                </p>
            </div>

            <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
                <h6 class="font-weight-bold">Contact</h6>
                <hr class="teal accent-3 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                <p>
                    <i class="fas fa-home mr-3"></i> 〒812-0016 福岡県福岡市博多区博多駅南2丁目12−32
                </p>
                <p>
                    <i class="fas fa-envelope mr-3"></i> info@example.com
                </p>
                <p>
                    <i class="fas fa-phone mr-3"></i> 012-345-6789
                </p>
            </div>
        </div>
    </div>

    <div class="footer-copyright text-center text-black-50 py-3" style="background-color: #ffe85e;">
        Copyright © 2019-2020 <a class="text-muted" href="http://www.asojuku.ac.jp/abcc/">麻生情報ビジネス専門学校</a>. All Rights Reserved.
    </div>
</footer>