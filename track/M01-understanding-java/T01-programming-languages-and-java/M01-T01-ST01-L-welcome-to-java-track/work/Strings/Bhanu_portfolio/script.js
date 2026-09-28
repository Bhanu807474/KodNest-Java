document.addEventListener("DOMContentLoaded", () => {
    // DOM Elements
    const header = document.getElementById("header");
    const navToggle = document.getElementById("navToggle");
    const navLinks = document.getElementById("navLinks");
    const navLinkItems = document.querySelectorAll(".nav-link");
    const scrollTopBtn = document.getElementById("scrollTopBtn");
    const themeToggle = document.getElementById("themeToggle");
    const toast = document.getElementById("toast");
    const toastMsg = document.getElementById("toast-msg");
    const sections = document.querySelectorAll("section");

    // ================= 1. DARK / LIGHT THEME TOGGLE =================
    const savedTheme = localStorage.getItem("portfolio-theme") || "dark";
    document.documentElement.setAttribute("data-theme", savedTheme);

    if (themeToggle) {
        themeToggle.addEventListener("click", () => {
            const currentTheme = document.documentElement.getAttribute("data-theme");
            const newTheme = currentTheme === "dark" ? "light" : "dark";
            document.documentElement.setAttribute("data-theme", newTheme);
            localStorage.setItem("portfolio-theme", newTheme);
        });
    }

    // ================= 2. DYNAMIC TYPEWRITER EFFECT =================
    const typingText = document.getElementById("typing-text");
    if (typingText) {
        const roles = [
            "Python Full Stack Developer",
            "ECE Graduate",
            "SQL & Database Specialist",
            "Problem Solver"
        ];
        let roleIndex = 0;
        let charIndex = 0;
        let isDeleting = false;
        let typingSpeed = 100;

        function typeEffect() {
            const currentRole = roles[roleIndex];

            if (isDeleting) {
                typingText.textContent = currentRole.substring(0, charIndex - 1);
                charIndex--;
                typingSpeed = 50;
            } else {
                typingText.textContent = currentRole.substring(0, charIndex + 1);
                charIndex++;
                typingSpeed = 100;
            }

            if (!isDeleting && charIndex === currentRole.length) {
                typingSpeed = 2000; // Pause at full word
                isDeleting = true;
            } else if (isDeleting && charIndex === 0) {
                isDeleting = false;
                roleIndex = (roleIndex + 1) % roles.length;
                typingSpeed = 500; // Pause before typing next word
            }

            setTimeout(typeEffect, typingSpeed);
        }

        typeEffect();
    }

    // ================= 3. MOBILE MENU TOGGLE =================
    if (navToggle && navLinks) {
        navToggle.addEventListener("click", () => {
            navLinks.classList.toggle("active");
            const icon = navToggle.querySelector("i");
            if (icon) {
                if (navLinks.classList.contains("active")) {
                    icon.classList.remove("fa-bars");
                    icon.classList.add("fa-xmark");
                } else {
                    icon.classList.remove("fa-xmark");
                    icon.classList.add("fa-bars");
                }
            }
        });

        // Close menu when a link is clicked
        navLinkItems.forEach(link => {
            link.addEventListener("click", () => {
                navLinks.classList.remove("active");
                const icon = navToggle.querySelector("i");
                if (icon) {
                    icon.classList.remove("fa-xmark");
                    icon.classList.add("fa-bars");
                }
            });
        });
    }

    // ================= 4. PROJECT CATEGORY FILTERING =================
    const filterBtns = document.querySelectorAll(".filter-btn");
    const projectCards = document.querySelectorAll(".project-card");

    filterBtns.forEach(btn => {
        btn.addEventListener("click", () => {
            filterBtns.forEach(b => b.classList.remove("active"));
            btn.classList.add("active");

            const filterValue = btn.getAttribute("data-filter");

            projectCards.forEach(card => {
                const category = card.getAttribute("data-category");
                if (filterValue === "all" || filterValue === category) {
                    card.style.display = "flex";
                    setTimeout(() => {
                        card.style.opacity = "1";
                        card.style.transform = "translateY(0)";
                    }, 50);
                } else {
                    card.style.opacity = "0";
                    card.style.transform = "translateY(20px)";
                    setTimeout(() => {
                        card.style.display = "none";
                    }, 300);
                }
            });
        });
    });

    // ================= 5. CLICK TO COPY & TOAST NOTIFICATION =================
    const copyableItems = document.querySelectorAll(".contact-item.copyable");

    function showToast(message) {
        if (!toast) return;
        if (toastMsg) toastMsg.textContent = message;
        toast.classList.add("show");
        setTimeout(() => {
            toast.classList.remove("show");
        }, 3000);
    }

    copyableItems.forEach(item => {
        item.addEventListener("click", (e) => {
            // Prevent triggering if clicked directly on an anchor tag href redirect
            if (e.target.tagName === "A") return;

            const textToCopy = item.getAttribute("data-copy");
            if (textToCopy) {
                navigator.clipboard.writeText(textToCopy).then(() => {
                    showToast(`Copied "${textToCopy}" to clipboard!`);
                }).catch(() => {
                    showToast("Failed to copy to clipboard.");
                });
            }
        });
    });

    // ================= 6. SCROLL HEADER & ACTIVE NAV LINK =================
    window.addEventListener("scroll", () => {
        const scrollY = window.scrollY;

        // Navbar shadow effect
        if (header) {
            if (scrollY > 50) {
                header.classList.add("scrolled");
            } else {
                header.classList.remove("scrolled");
            }
        }

        // Scroll to top button visibility
        if (scrollTopBtn) {
            if (scrollY > 300) {
                scrollTopBtn.classList.add("show");
            } else {
                scrollTopBtn.classList.remove("show");
            }
        }

        // Highlight active nav item on scroll
        let currentSectionId = "";
        sections.forEach(section => {
            const sectionTop = section.offsetTop - 120;
            const sectionHeight = section.offsetHeight;
            if (scrollY >= sectionTop && scrollY < sectionTop + sectionHeight) {
                currentSectionId = section.getAttribute("id");
            }
        });

        if (currentSectionId) {
            navLinkItems.forEach(link => {
                link.classList.remove("active");
                if (link.getAttribute("href") === `#${currentSectionId}`) {
                    link.classList.add("active");
                }
            });
        }
    });

    // ================= 7. SCROLL TO TOP CLICK HANDLER =================
    if (scrollTopBtn) {
        scrollTopBtn.addEventListener("click", () => {
            window.scrollTo({
                top: 0,
                behavior: "smooth"
            });
        });
    }

    // ================= 8. REVEAL ANIMATIONS ON SCROLL =================
    const observerOptions = {
        threshold: 0.15,
        rootMargin: "0px 0px -40px 0px"
    };

    const revealObserver = new IntersectionObserver((entries, observer) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                entry.target.style.opacity = "1";
                entry.target.style.transform = "translateY(0)";
                observer.unobserve(entry.target);
            }
        });
    }, observerOptions);

    const animatedElements = document.querySelectorAll(".glass-card, .timeline-item");
    animatedElements.forEach(el => {
        el.style.opacity = "0";
        el.style.transform = "translateY(25px)";
        el.style.transition = "opacity 0.6s cubic-bezier(0.16, 1, 0.3, 1), transform 0.6s cubic-bezier(0.16, 1, 0.3, 1)";
        revealObserver.observe(el);
    });
});
