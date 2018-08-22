let Storage = {

    localhostUrl: null,

    getLocalhostUrl: () => {
        return Storage.localhostUrl;
    },

    setLocalhostUrl: (url) => {
        Storage.localhostUrl = url;
    }
};

export default Storage;
