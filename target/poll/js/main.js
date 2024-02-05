import { router } from './router.js';
import { PollList } from './components/poll-list.js';

router.register('/', PollList);
router.register('/poll-list', PollList);

if (location.hash)
	router.navigate(location.hash.replace('#', ''))
else router.navigate('/');
