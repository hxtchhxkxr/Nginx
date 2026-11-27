# Nginx 학습 기록

Windows 로컬 환경에서 Nginx(8081)와 Spring Boot(8080)를 연결하고, 케이크 상품 페이지를 통해 HTTP 요청 흐름을 실습했다.

## 학습 목차

1. **Nginx 실행과 설정** — `nginx.conf`의 `server`, `listen`, `location` 구조 이해와 설정 검사(`-t`) 및 적용(`-s reload`)
2. **정적 파일 제공** — `root`와 `index`를 설정해 `/` 요청에 `web/index.html` 응답
3. **리버스 프록시** — `proxy_pass`로 `/api/products` 요청을 Spring Boot에 전달하고, 8080 직접 호출과 8081 경유 호출 비교
4. **상품 페이지와 API 연동** — `fetch('/api/products')`로 케이크 목록을 표시하고 브라우저 개발자 도구에서 요청 확인
5. **로그 확인과 장애 복구** — `access.log`와 `error.log`로 요청 추적. Spring Boot 중단 시 페이지 `200`·API `502`, 재시작 후 API `200` 확인
6. **경로 매칭과 리다이렉트** — `location /api/` 설정에서 `/api` 요청이 `/api/`로 `301` 리다이렉트되고, `curl.exe -i -L`로 따라가면 Spring Boot가 `404`를 반환하는 흐름 확인