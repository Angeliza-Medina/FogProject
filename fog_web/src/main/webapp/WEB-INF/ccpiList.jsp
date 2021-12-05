<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Fog - CCPI Liste</title>

    <link rel="icon" type="image/png" href="../assets/images/logo/favicon.jpg"/>

    <!-- CSS -->
    <link rel="stylesheet" href="../assets/css/base.css">
    <link rel="stylesheet" href="../assets/css/admin_header.css">
    <link rel="stylesheet" href="../assets/css/ccpiList.css">
    <link rel="stylesheet" href="../assets/css/admin_footer.css">

    <!-- Fonts -->
    <script src="https://kit.fontawesome.com/ca25e16baf.js" crossorigin="anonymous"></script>
</head>

<body>
<div id="wrapper">
    <header>
        <div id="header_container" class="flexRow">
            <div id="logo_container" class="posRelative">
                <img src="assets/images/logo/logo.png" alt="Johannes Fog logo">
                <a id="logo_link" href="index.html"></a>
            </div>

            <div id="headerNav_container" class="flexColumn">
                <div id="headerNavTop_container" class="flexRow">
                    <div id="logout_container" class="flexRow">
                        <div id="logoutLink_container">
                            <a id="logout_link" href="index.html">
                                <i class="fas fa-user-circle"></i>
                                Log ud
                            </a>
                        </div>

                        <div id="email_container">
                            admin@gmail.com
                        </div>
                    </div> <!-- #logout_container .flexRow END -->

                    <div id="topNav_container" class="flexRow">
                        <div class="topNavLink_container">
                            <a href="" class="header_link topNav_link">Outlet</a>
                        </div>

                        <div class="topNavLink_container">
                            <a href="" class="header_link topNav_link">Bolig & Designhus</a>
                        </div>

                        <div class="topNavLink_container">
                            <a href="" class="header_link topNav_link">Trælast & Byggecenter</a>
                        </div>

                        <div class="topNavLink_container">
                            <a href="" class="header_link topNav_link">FogPro</a>
                        </div>
                    </div>
                </div> <!-- #headerNavTop_container .flexRow END -->

                <div id="headerNavBtm_container" class="flexRow">
                    <section id="navBtm_section" class="flexRow">
                        <div class="btmNavLink_container">
                            <a href="" class="header_link">
                                Behandl carport forespørgsler
                            </a>
                        </div>

                        <div class="btmNavLink_container">
                            <a href="" class="header_link">
                                Rediger produkter
                            </a>
                        </div>
                </div> <!-- #headerNavBtm_container .flexRow END -->
            </div> <!-- #headerNav_container .flexColumn END -->
        </div>
    </header>

    <main>
        <div id="pageHeadline_container">
            <h2>Carport forespørgsler</h2>
        </div>


    </main>



    <footer id="adminFooter" class="flexRow">
        <section id="businessInfo">
            Johannes Fog A/S - Firskovvej 20 - 2800 Lyngby - CVR-nr. 16314439
        </section>

        <section id="priceInfo">
            Alle priser er inkl. moms
        </section>
    </footer>
</div> <!-- #wrapper END -->

<script src="../assets/js/ccpiList.js"></script>
</body>
</html>
