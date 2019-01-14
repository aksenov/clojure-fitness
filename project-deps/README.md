# Create projects with Clojure tools.deps only

* [Deps and CLI Guide](https://clojure.org/guides/deps_and_cli)
* [Tools on tools.deps](https://github.com/clojure/tools.deps.alpha/wiki/Tools)

# Features

* `~/.clojure/deps.edn` - global project profile, you can specify global dependencies and aliases here
* most tools like [clj-new](https://github.com/seancorfield/clj-new) works over deps.edn aliases ```clj -A:new app myname/myapp```

# Troubles

* clj does not work with proxy settings: https://dev.clojure.org/jira/browse/TDEPS-20
