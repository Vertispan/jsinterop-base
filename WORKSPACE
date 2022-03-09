workspace(name = "com_google_jsinterop_base")

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")
load("@bazel_tools//tools/build_defs/repo:jvm.bzl", "jvm_maven_import_external")
load("@bazel_tools//tools/build_defs/repo:git.bzl", "git_repository")

# Load j2cl repository
_J2CL_VERSION = "2013411d2e659e207b5f637585be06a279a47467"
http_archive(
    name = "com_google_j2cl",
    strip_prefix = "j2cl-%s" % _J2CL_VERSION,
    url = "https://github.com/google/j2cl/archive/%s.zip" % _J2CL_VERSION,
)

load("@com_google_j2cl//build_defs:repository.bzl", "load_j2cl_repo_deps")

load_j2cl_repo_deps()

load("@com_google_j2cl//build_defs:rules.bzl", "setup_j2cl_workspace")

setup_j2cl_workspace()

jvm_maven_import_external(
    name = "org_gwtproject_gwt_dev",
    artifact = "com.google.gwt:gwt-dev:2.9.0",
    server_urls = ["https://repo1.maven.org/maven2/"],
    licenses = ["notice"],
)

git_repository(
    name = "bazel_common",
    remote = "https://github.com/google/bazel-common.git",
    commit = "bf8e5ef",
)