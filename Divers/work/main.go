package main
 
import (
	"fmt"
	"net/http"
)
 
func main() {
	app := http.HandlerFunc(PageFinale)      // http.Handler
	mw := LogMiddleware(AuthMiddleware(app)) // http.Handler
 
	http.ListenAndServe(":3000", mw)
}
 
func PageFinale(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(w, "Hello Destin, C'est mon serveur")
}
 
func LogMiddleware(next http.Handler) http.Handler {
	return http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		fmt.Println("Prints logs")
		next.ServeHTTP(w, r)
	})
}
 
func AuthMiddleware(next http.Handler) http.Handler {
	return http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		fmt.Println("You're allowed to see the final page")
		next.ServeHTTP(w, r)
	})
}

// https://golang.io/fr/tutoriels/les-middlewares-avec-go/